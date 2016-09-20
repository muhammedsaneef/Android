package com.example.saneef.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.Toast;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    String username,password;

    SignUpActivity loginCheck;
    SharedPreferences localDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button b=(Button)findViewById(R.id.button);
        //b.setOnClickListener(this);
        loginCheck =new SignUpActivity();
        localDb=getSharedPreferences("userData",0);



    }
    public void clearLocalDb(View v)
    {
        SharedPreferences.Editor localDbEditor=localDb.edit();
        localDbEditor.clear();
        localDbEditor.commit();
        Toast alertUser=Toast.makeText(this,"Local DB cleared",Toast.LENGTH_SHORT);
        alertUser.show();
    }

    public boolean isUserPresent(List<Person> users,String username)
    {
        boolean userPresent=false;
        for(Person person :users)
        {
            if(person.getUserName().equals(username))
            {
                userPresent=true;
            }

        }
        return userPresent;
    }
    public void login(View v)
    {

        EditText usernameField=(EditText)findViewById(R.id.editText);
        EditText passwordField=(EditText)findViewById(R.id.editText2);
        username=usernameField.getText().toString();
        password=passwordField.getText().toString();

        if(!username.isEmpty() && !password.isEmpty())
        {
                    String stored_username=localDb.getString(username,"");
                    String stored_password=stored_username.substring(stored_username.indexOf(",")+1,stored_username.length());
                    if(!stored_username.isEmpty())
                    {
                        if(stored_password.equals(password)) {
                            Intent loginActivity = new Intent(this, SubActivity.class);
                            loginActivity.putExtra("Username", username);

                            startActivity(loginActivity);
                            finish();
                        }
                        else
                        {
                            Toast alertUser=Toast.makeText(this,"Invalid password",Toast.LENGTH_SHORT);
                            alertUser.show();
                        }
                    }
                    else
                    {
                        Toast alertUser=Toast.makeText(this,"Not Registered",Toast.LENGTH_SHORT);
                        alertUser.show();
                    }

        }
        else if (username.isEmpty())
        {
            Toast alertUser=Toast.makeText(this,"Enter username",Toast.LENGTH_SHORT);
            alertUser.show();
        }
        else
        {
            Toast alertUser=Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT);
            alertUser.show();
        }

    }
    /*Method to set onclick Listener via switch
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:

        }
    }
    */
    public void signUp(View v)
    {
        Intent signUpActivity=new Intent(this,SignUpActivity.class);
        startActivity(signUpActivity);

    }
}
