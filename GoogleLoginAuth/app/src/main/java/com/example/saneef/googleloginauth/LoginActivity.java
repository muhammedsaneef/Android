package com.example.saneef.googleloginauth;

import android.app.Dialog;
import android.content.Intent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.auth.api.Auth;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;

import com.google.android.gms.common.api.Status;

import com.google.api.services.people.v1.People;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import RetrofitClass.Constants;
import RetrofitClass.JsonModel.PeopleAPI;
import RetrofitClass.JsonModel.ServerResponse;
import RetrofitClass.JsonModel.TokenExchangeResponse;
import RetrofitClass.RetrofitBuilder;
import RetrofitClass.ServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    GoogleSignInOptions googleSignInOptions;
    GoogleApiClient googleApiClient;
    Dialog authorization_window;
    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener;
    WebView browser;
    private String access_token;
    private String authorization_code;

    private void loadAuthorizationUrl()
    {



        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(Constants.OAUTH_URL+"?redirect_uri="+Constants.REDIRECT_URI+"&response_type=code&client_id="+Constants.web_client_id+"&scope="+Constants.required_Scope);

        browser.setWebViewClient(new WebViewClient() {

            boolean authComplete = false;
            Intent resultIntent = new Intent();

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);

            }

            String authCode;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (url.contains("?code=") && authComplete != true)
                {
                    Uri uri = Uri.parse(url);
                    authCode = uri.getQueryParameter("code");
                    //Log.v( "CODE : " , authCode);
                    authorization_code=authCode;
                    authComplete = true;



                    authorization_window.dismiss();

                    Log.v("AuthCode",authorization_code);
                    if(!authorization_code.isEmpty())
                    {
                        Thread thread = new Thread() {
                            @Override
                            public void run() {

                                requestContacts();
                            }
                        };

                        thread.start();
                    }

                }
                else if(url.contains("error=access_denied")){
                    Log.i("", "ACCESS_DENIED_HERE");

                    Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_SHORT).show();

                    authorization_window.dismiss();
                }
            }
        });

    }

    private void googleSetup()
    {

        googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,onConnectionFailedListener).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

    }

    private void authDialogSetup()
    {
        authorization_window=new Dialog(LoginActivity.this);
        authorization_window.setTitle("Grant access");
        authorization_window.setCancelable(true);
        authorization_window.setContentView(R.layout.web_authorization_layout);
        browser=(WebView)authorization_window.findViewById(R.id.browser_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsible_layout);
        //configure google sign_in
        googleSetup();
        //find button views
        Button view_contacts_button=(Button)findViewById(R.id.view_user_contacts);
       FloatingActionButton sign_out_fab =(FloatingActionButton)findViewById(R.id.fab);

       authDialogSetup();

        view_contacts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //authorization_window.show();
                //loadAuthorizationUrl();
                RetrofitBuilder retrofitBuilder=new RetrofitBuilder();

               Retrofit retrofitObject=retrofitBuilder.getTokenRetrofit();
                ServiceAPI serviceAPI=retrofitObject.create(ServiceAPI.class);

                Call<TokenExchangeResponse> request_Token =  serviceAPI.getAccessToken(authorization_code,Constants.REDIRECT_URI,Constants.web_client_id,Constants.web_client_secret,"authorization_code");
                request_Token.enqueue(new Callback<TokenExchangeResponse>() {
                    @Override
                    public void onResponse(Call<TokenExchangeResponse> call, Response<TokenExchangeResponse> response) {
                        //Log.v("response",response.body().toString());
                        access_token=response.body().getAccess_token();
                        Log.v("Token",access_token);
                    }

                    @Override
                    public void onFailure(Call<TokenExchangeResponse> call, Throwable t) {

                        Log.v("TokenFailure",t.toString());
                    }
                });

                retrofitObject=retrofitBuilder.getContactsRetrofit();

                PeopleAPI peopleAPI=retrofitObject.create(PeopleAPI.class);
                String bearer_access="Bearer "+access_token;
                Call<ServerResponse> request_Contacts=peopleAPI.getContacts(1,"person.names,person.email_addresses",bearer_access);
                request_Contacts.enqueue(new Callback<ServerResponse>() {
                    @Override
                    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                        Log.v("Contacts",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<ServerResponse> call, Throwable t) {

                    }
                });

            }
        });
        sign_out_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });





        //Set Toolbar
       Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("Google");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout collapsingToolbarLayout =(CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Google");
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this,R.color.toolbar_color));

        Intent intent=getIntent();
        Toast.makeText(this,"Signed In",Toast.LENGTH_SHORT).show();

        String message="Profile picture not available.";
        String photo_url=intent.getStringExtra("photo_url");
        String display_name=intent.getStringExtra("displayName");
        String email_id=intent.getStringExtra("email");
        String user_id=intent.getStringExtra("userID");
        authorization_code=intent.getStringExtra("auth");
        if(photo_url.compareTo(message)!=0) {
            Uri photo_id = Uri.parse(photo_url);
            //Set contents to view
            ImageView photo_dp = (ImageView) findViewById(R.id.profile_photo);
            //Set dp
            setProfilePicture(photo_dp, photo_id);
        }
        else
        {
            Toast.makeText(this,"Profile picture failed",Toast.LENGTH_SHORT).show();
        }
        //set details
        //TextView display_name_field=(TextView)findViewById(R.id.displayName);
        TextView email_id_field=(TextView)findViewById(R.id.emailId);
        TextView user_id_field=(TextView)findViewById(R.id.user_id);



        String textToDisplay;
        //=(display_name_field.getText().toString()+" "+display_name);
        //display_name_field.setText(textToDisplay);
        //Set profile name

        collapsingToolbarLayout.setTitle(display_name);

        //extract other info
        textToDisplay=email_id_field.getText().toString()+" "+email_id;
        email_id_field.setText(textToDisplay);
        textToDisplay=user_id_field.getText().toString()+" "+user_id;
        user_id_field.setText(textToDisplay);

    }


    public void setProfilePicture(ImageView v, Uri uri)
    {
       Picasso.with(this).load(uri.toString()).resize(500,500).centerCrop().into(v);
    }
    public void logout(View v)
    {
        boolean status=signOutFromGoogleAccount();
        if(status)
        {
           //Snackbar.make(v, "Signed Out", Snackbar.LENGTH_SHORT).show();
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        boolean status=signOutFromGoogleAccount();
        if(status)
        {
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public boolean signOutFromGoogleAccount()
    {
        if (googleApiClient.isConnected())
        {
            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {

                        }
                    });
            return true;
        }
        return false;
    }



    private void requestContacts()
    {
        PeopleConnection peopleConnection=new PeopleConnection(authorization_code,Constants.web_client_id,Constants.web_client_secret,Constants.REDIRECT_URI);

        try {
            peopleConnection.setUp();
            People linkUser =peopleConnection.getPeopleService();
            People.PeopleOperations.Connections contacts= linkUser.people().connections();

        }
        catch (IOException ex)
        {
            Log.v("Error",ex.toString());
        }
    }




}
