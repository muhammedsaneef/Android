package com.example.saneef.googleloginauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent=getIntent();
        Toast.makeText(this,"Signed In",Toast.LENGTH_SHORT).show();
        String display_name=intent.getStringExtra("displayName");
        String email_id=intent.getStringExtra("email");
        String user_id=intent.getStringExtra("userID");

        //Set contents to view
       TextView display_name_field=(TextView)findViewById(R.id.displayName);
        TextView email_id_field=(TextView)findViewById(R.id.emailId);
        TextView user_id_field=(TextView)findViewById(R.id.user_id);

        display_name_field.setText((display_name_field.getText().toString()+" "+display_name));
        email_id_field.setText(email_id_field.getText().toString()+" "+email_id);
        user_id_field.setText(user_id_field.getText().toString()+" "+user_id);

    }
    public void logout(View v)
    {
        Toast.makeText(this,"Signed Out",Toast.LENGTH_SHORT).show();
        finish();
    }
    @Override
    public void onBackPressed()
    {
     //Do Nothing
    }
}
