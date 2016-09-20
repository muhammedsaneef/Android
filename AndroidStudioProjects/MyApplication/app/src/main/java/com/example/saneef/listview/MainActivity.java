package com.example.saneef.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView ;
    private listAdapter contactAdapter ;
    private static final int request_code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById( R.id.list_view);
        ArrayList<Person> contacts=new ArrayList<>();




        // Create ArrayAdapter using the planet list.
       contactAdapter = new listAdapter(this,contacts );




        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( contactAdapter);
    }

    public void addContact(View v)
    {
        Intent addContactActivity = new Intent(this,AddContact.class);
        startActivityForResult(addContactActivity,request_code);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == request_code) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                Person newContact=new Person();
                String person_name=data.getStringExtra("contact_name");
                String person_number=data.getStringExtra("contact_number");

                newContact.setPersonName(person_name);
                newContact.setPhoneNumber(person_number);

                contactAdapter.addContact(newContact);

            }
        }
    }

}
