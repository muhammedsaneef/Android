package com.example.saneef.googleloginauth;


import android.accounts.AccountManager;
import android.content.Intent;

import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.auth.api.*;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.services.people.v1.People;
import com.google.api.services.people.v1.PeopleScopes;

import java.util.Set;

import RetrofitClass.Constants;


public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 9001;
    GoogleSignInOptions googleSignInOptions;
    GoogleApiClient googleApiClient;

    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener;
    Intent loginActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                                    .requestEmail()
                                                    .requestServerAuthCode(Constants.web_client_id)
                                                    .requestScopes(new Scope(PeopleScopes.CONTACTS_READONLY),
                                                                   new Scope(PeopleScopes.USERINFO_PROFILE),
                                                                   new Scope(PeopleScopes.PLUS_LOGIN))
                                                    .build();
        googleApiClient=new GoogleApiClient.Builder(this)
                                           .enableAutoManage(this,onConnectionFailedListener)
                                           .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                                           .build();


    }

    public void performGoogleAuthentication(View v)
    {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent,RC_SIGN_IN);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        //Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {

            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
                Set scopes_given=acct.getGrantedScopes();




                String userDisplayName = acct.getDisplayName();
                String email = acct.getEmail();
                String user_id = acct.getId();
                String authCode=acct.getServerAuthCode();
                Uri photo_url = acct.getPhotoUrl();
                Log.v("AuthCode: ",authCode);

               loginActivity=new Intent(this,LoginActivity.class);


                if(photo_url!=null) {
                    loginActivity.putExtra("photo_url", photo_url.toString());

                }
                else
                {
                    loginActivity.putExtra("photo_url", "Profile picture not available.");
                }
                if(userDisplayName!=null)
                {
                    loginActivity.putExtra("displayName", userDisplayName);
                }
            else{
                    loginActivity.putExtra("displayName", "Display Name.");
                }

                loginActivity.putExtra("email", email);
                loginActivity.putExtra("userID", user_id);

                loginActivity.putExtra("auth",authCode);
            //navigate to second activity
            startActivity(loginActivity);

        }
        else
        {
            Toast.makeText(this,"Connection error",Toast.LENGTH_SHORT).show();
        }

    }


}
