package com.example.saneef.loginapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    String personName,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void submitProfile(View v)
    {
        EditText personNameField=(EditText)findViewById(R.id.personName);
        EditText usernameField=(EditText)findViewById(R.id.userName);
        EditText passwordField=(EditText)findViewById(R.id.password);
        personName=personNameField.getText().toString();
        username=usernameField.getText().toString();
        password=passwordField.getText().toString();
        Toast userFeedback=Toast.makeText(this,"message",Toast.LENGTH_SHORT);
        if(!personName.isEmpty() && !username.isEmpty() && !password.isEmpty())
        {

            userFeedback.setText("Profile created");
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
