package com.example.saneef.googleloginauth;

/**
 * Created by saneef on 15/9/16.
 */
import android.util.Log;

import com.google.api.client.auth.oauth2.TokenResponseException;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.people.v1.People;


import java.io.IOException;

public class PeopleConnection {
    private String authorization_code;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private People peopleService;

    public PeopleConnection(String authorization_code, String clientId, String clientSecret, String redirectUrl) {
        this.authorization_code = authorization_code;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }



    public void setUp() throws IOException {
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();

        GoogleTokenResponse tokenResponse;

try {
    // Step 2: Exchange -->
   tokenResponse = new GoogleAuthorizationCodeTokenRequest(
           httpTransport,
            jsonFactory,
            clientId,
            clientSecret,
            authorization_code,
            redirectUrl).execute();
    // End of Step 2 <--.






    GoogleCredential credential = new GoogleCredential.Builder()
            .setTransport(httpTransport)
            .setJsonFactory(jsonFactory)
            .setClientSecrets(clientId, clientSecret)
            .build()
            .setFromTokenResponse(tokenResponse);

    peopleService = new People.Builder(httpTransport, jsonFactory, credential)
            .build();
}
catch(TokenResponseException ex)
{
    Log.v("TokenError",ex.toString());
}


    }
}