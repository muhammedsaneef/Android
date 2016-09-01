package com.example.saneef.loginapp;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {


    private List<Person> users;
    SharedPreferences localDb;
    SharedPreferences.Editor localDbEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        users =new ArrayList<>();
        localDb=getSharedPreferences("userData",0);
        localDbEditor=localDb.edit();
    }

    public List<Person> getUsers() {
        return users;
    }

    public void submitProfile(View v)
    {
        String personName,username,password;
        EditText personNameField=(EditText)findViewById(R.id.personName);
        EditText usernameField=(EditText)findViewById(R.id.userName);
        EditText passwordField=(EditText)findViewById(R.id.password);
        //get contents of profile information
        personName=personNameField.getText().toString();
        username=usernameField.getText().toString();
        password=passwordField.getText().toString();
        //create Toast for giving user feedback
        Toast userFeedback=Toast.makeText(this,"message",Toast.LENGTH_SHORT);
        if(!personName.isEmpty() && !username.isEmpty() && !password.isEmpty())
        {

            userFeedback.setText("Profile created");
            //create object of new user
            Person newUser =new Person();
            newUser.setPersonName(personName);
            newUser.setUserName(username);
            newUser.setPassword(password);
            //Add object to users list
            users.add(newUser);
            localDbEditor.putString(username,personName+","+password);
            localDbEditor.commit();

            //startActivity(new Intent(this,MainActivity.class));
            finish();
        }
        else if(personName.isEmpty())
        {
            userFeedback.setText("Don't have a name? ");


        }
        else if(username.isEmpty())
        {
            userFeedback.setText("Username needed");

        }
        else
        {
            userFeedback.setText("Enter password");
        }
        userFeedback.show();

    }
}
