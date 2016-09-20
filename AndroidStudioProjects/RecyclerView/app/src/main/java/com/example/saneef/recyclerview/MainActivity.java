package com.example.saneef.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.contacts_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Person> contacts=new ArrayList<>();
        Person p1=new Person();
        p1.setDisplayName("hgjhg");
        p1.setEmailAddress("sdfsdf");



        // specify an adapter (see also next example)
       listAdapter= new ListAdapter(contacts);
        listAdapter.add(p1);
        mRecyclerView.setAdapter(listAdapter);
    }
}
