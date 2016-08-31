package com.example.saneef.loginapp;

import android.content.Intent;
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
        TextView givenUsername=(TextView)findViewById(R.id.usernameField);
        TextView givenPassword=(TextView)findViewById(R.id.passwordField);
        String welcomeUser=givenUsername.getText().toString()+" "+newIntent.getStringExtra("Username");
        String password=givenPassword.getText().toString()+" "+newIntent.getStringExtra("Password");
        givenUsername.setText(welcomeUser);
        givenPassword.setText(password);

    }
}
