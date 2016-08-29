package com.example.saneef.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int countOfClick,maxCountValue;
    TextView countDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDisplay= (TextView)findViewById(R.id.textView3);
        countOfClick=0;
        maxCountValue=50;
    }
    public void clickCounter(View v)
    {
        if(countOfClick<maxCountValue)
        {
            countOfClick++;
        }
        else
        {
            Toast.makeText(this,"Max Limit reached",Toast.LENGTH_SHORT).show();
            resetCounter(v);
        }
        displayCounterValue();
    }
    public void resetCounter(View v)
    {
        countOfClick=0;
        displayCounterValue();
        Toast.makeText(this,"Count reset to zero",Toast.LENGTH_SHORT).show();
    }
    public void displayCounterValue()
    {

        countDisplay.setText(Integer.toString(countOfClick));
    }
}
