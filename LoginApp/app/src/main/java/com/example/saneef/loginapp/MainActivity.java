package com.example.saneef.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    String username,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button b=(Button)findViewById(R.id.button);
        //b.setOnClickListener(this);
        username="";
    }



    public void login(View v)
    {

        EditText usernameField=(EditText)findViewById(R.id.editText);
        EditText passwordField=(EditText)findViewById(R.id.editText2);
        username=usernameField.getText().toString();
        password=passwordField.getText().toString();

        if(!username.isEmpty() && !password.isEmpty())
        {

            Intent loginActivity=new Intent(this,SubActivity.class);
            loginActivity.putExtra("Username",username);
            loginActivity.putExtra("Password",password);
            startActivity(loginActivity);
            finish();
        }
        else if (username.isEmpty())
        {
            Toast alertUser=Toast.makeText(this,"Enter valid name",Toast.LENGTH_SHORT);
            alertUser.show();
        }
        else
        {
            Toast alertUser=Toast.makeText(this,"Enter valid password",Toast.LENGTH_SHORT);
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
