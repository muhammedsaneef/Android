package com.example.saneef.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    TextView person_name,phone_number;
    String name,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        person_name=(TextView)findViewById(R.id.add_contact_personName);
        phone_number=(TextView)findViewById(R.id.add_contact_phone_number);

    }

    public void newContact(View v)
    {
        name=person_name.getText().toString();
        number=phone_number.getText().toString();
        Toast toast =Toast.makeText(this,"message",Toast.LENGTH_SHORT);
        if(name.isEmpty())
        {
            toast.setText("Enter your name");
            toast.show();
        }
        else if (number.isEmpty())
        {
            toast.setText("Enter phone number");
            toast.show();
        }
        else
        {
            Intent intent =new Intent();
            intent.putExtra("contact_name",name);
            intent.putExtra("contact_number",number);
            setResult(RESULT_OK,intent);
            finish();
        }

    }
}
