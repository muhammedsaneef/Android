package com.example.saneef.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

public class SubActivity extends AppCompatActivity {


  @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent newIntent=getIntent();
        SharedPreferences localDb=getSharedPreferences("userData",0);
        //fetch data from local storage
        String userDetails=localDb.getString(newIntent.getStringExtra("Username"),"");
        //identify textfields to display content of user
        TextView givenUsername=(TextView)findViewById(R.id.usernameField);
        TextView givenPassword=(TextView)findViewById(R.id.passwordField);
        TextView givenPersonName=(TextView)findViewById(R.id.personName);
        //extract each data from combined result
        String personNameText=userDetails.substring(0,userDetails.lastIndexOf(","));
        String passwordText=userDetails.substring(userDetails.indexOf(",")+1, userDetails.length());
        //create new content to display
        String welcomeUser=givenUsername.getText().toString()+" "+newIntent.getStringExtra("Username");
        String password=givenPassword.getText().toString()+" "+passwordText;
        String personName=givenPersonName.getText().toString()+" "+personNameText;
        //set new content to existing views
        givenUsername.setText(welcomeUser);
        givenPassword.setText(password);
        givenPersonName.setText(personName);

    }
}
