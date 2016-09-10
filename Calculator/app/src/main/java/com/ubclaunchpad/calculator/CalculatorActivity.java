package com.ubclaunchpad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();

    EditText number1;
    EditText number2;

    Button add;
    Button sub;
    Button mul;
    Button div;
    Button exp;

    TextView result;

    double num1, num2;
    double output = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        number1 = (EditText)findViewById(R.id.firstInput);
        number2 = (EditText)findViewById(R.id.secondInput);

        add = (Button)findViewById(R.id.operation_add);
        sub = (Button)findViewById(R.id.operation_sub);
        mul = (Button)findViewById(R.id.operation_multi);
        div = (Button)findViewById(R.id.operation_div);
        exp = (Button)findViewById(R.id.operation_extra1);

        result = (TextView)findViewById(R.id.answerCal);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        exp.setOnClickListener(this);
    }



    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {

        num1 = Double.parseDouble(number1.getText().toString());
        num2 = Double.parseDouble(number2.getText().toString());

        if (TextUtils.isEmpty(number1.getText().toString()) || TextUtils.isEmpty(number2.getText().toString())) {
            result.setText("Invalid");
            return;
        }

        switch (v.getId())
        {

            case R.id.operation_add:
            {
                //TODO add function
                output = num1 + num2;
                break;
            }
            case R.id.operation_sub:
            {
                //TODO subtract function
                output = num1 - num2;
                break;
            }
            case R.id.operation_multi:
            {
                //TODO multiply function
                output = num1 * num2;
                break;
            }
            case R.id.operation_div:
            {
                //TODO divide function
                output = num1 / num2;
                break;
            }
            //TODO any extra implmentations (optional)
            case R.id.operation_extra1:
            {
                output = Math.exp(num1);
            }
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;
            }
        }
        result.setText(Double.toString(output));
    }
}
