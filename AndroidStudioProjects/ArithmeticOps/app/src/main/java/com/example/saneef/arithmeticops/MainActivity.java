package com.example.saneef.arithmeticops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float operand1,operand2,resultValue;
    char op;
    TextView resultField;
    EditText contentOfNumber1,contentOfNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField=(TextView)findViewById(R.id.textView);
        contentOfNumber1=(EditText)findViewById(R.id.number1);
        contentOfNumber2=(EditText)findViewById(R.id.number2);
        operand1=0;
        operand2=0;
    }
    public void displayResult(float valueToDisplay)
    {
        resultField.setText(Float.toString(valueToDisplay));
    }
    public void clearField(View v)
    {
        operand1=0;
        operand2=0;
        resultValue=0;
        contentOfNumber1.setText("");
        contentOfNumber2.setText("");
        displayResult(resultValue);
    }
    public void operationPerformed(View v) {

        Button buttonPressed = (Button) v;
        op = buttonPressed.getText().charAt(0);
        try {
            operand1 = Float.parseFloat(contentOfNumber1.getText().toString());
            operand2 = Float.parseFloat(contentOfNumber2.getText().toString());
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Enter valid numbers",Toast.LENGTH_SHORT).show();
        }
            switch (op)

            {
                case '+':
                    resultValue = operand1 + operand2;
                    displayResult(resultValue);
                    break;
                case '-':
                    resultValue = operand1-operand2;
                    displayResult(resultValue);
                    break;
                case '*':
                    resultValue = operand1*operand2;
                    displayResult(resultValue);
                    break;
                case '/':
                    if (operand2 != 0) {
                        resultValue = operand1 / operand2;
                        displayResult(resultValue);
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }

                    break;
            }


    }
}
