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

    float number1,number2,resultValue;
    char op;
    TextView resultField;
    EditText num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField=(TextView)findViewById(R.id.textView);
        num1=(EditText)findViewById(R.id.number1);
        num2=(EditText)findViewById(R.id.number2);
        number1=0;
        number2=0;
    }
    public void displayResult(float valueToDisplay)
    {
        resultField.setText(Float.toString(valueToDisplay));
    }
    public void clearField(View v)
    {
        number1=0;
        number2=0;
        resultValue=0;
        num1.setText("0");
        num2.setText("0");
        displayResult(resultValue);
    }
    public void operationPerformed(View v) {

        Button buttonPressed = (Button) v;
        op = buttonPressed.getText().charAt(0);
        try {
            number1 = Float.parseFloat(num1.getText().toString());
            number2 = Float.parseFloat(num2.getText().toString());
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Enter valid numbers",Toast.LENGTH_SHORT).show();
        }
            switch (op)

            {
                case '+':
                    resultValue = number1 + number2;
                    displayResult(resultValue);
                    break;
                case '-':
                    resultValue = number1 - number2;
                    displayResult(resultValue);
                    break;
                case '*':
                    resultValue = number1 * number2;
                    displayResult(resultValue);
                    break;
                case '/':
                    if (number2 != 0) {
                        resultValue = number1 / number2;
                        displayResult(resultValue);
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }

                    break;
            }


    }
}
