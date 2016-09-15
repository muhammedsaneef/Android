package com.example.saneef.googleloginauth;

import android.content.Intent;

import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.auth.api.Auth;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;

import com.squareup.picasso.Picasso;



public class LoginActivity extends AppCompatActivity {

    GoogleSignInOptions googleSignInOptions;
    GoogleApiClient googleApiClient;

    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsible_layout);

        googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().requestScopes(new Scope(Scopes.PROFILE)).build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,onConnectionFailedListener).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

        Button sign_out_Button=(Button)findViewById(R.id.sign_out_button_);
       FloatingActionButton sign_out_fab =(FloatingActionButton)findViewById(R.id.fab);

        sign_out_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });



        sign_out_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // logout(v);
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
       Picasso.with(this).load(uri.toString()).resize(300,300).centerCrop().into(v);
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





}
