package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonRuppee;
    Button buttonDollor;


    public  void convertCurrency(View view){
       // Log.i("Info", "Button pressed");

        editText = (EditText)findViewById(R.id.edit);

        String amountinDollor = editText.getText().toString();


        if(TextUtils.isEmpty(amountinDollor)) {
            editText.setError("Please Enter the value");
            return;
        }

        double amountinDollorDouble = Double.parseDouble(amountinDollor);

        double amountinRuppee = amountinDollorDouble * 74.8;

        String amountinRuppeeString = String.format("%.2f", amountinRuppee);

        //Log.i("Amount in Ruppee", amountinRuppeeString);

        Toast.makeText(this, "$"+ amountinDollor + "is Rs. "+ amountinRuppeeString, Toast.LENGTH_LONG).show();
    }

    public void convertToDollor(View view){
        editText = (EditText)findViewById(R.id.edit);

        String amountInRuppee = editText.getText().toString();

        Log.i("Info", "Rupee button pressed");

        if(TextUtils.isEmpty(amountInRuppee)) {
            editText.setError("Please Enter the value");
            return;
        }

        double amountInRuppeDouble = Double.parseDouble(amountInRuppee);

        double amountInDollor = amountInRuppeDouble / 74.8;

        String amountInDollorString = String.format("%.3f", amountInDollor);

        Toast.makeText(this,"Rs. "+ amountInRuppee + "is $ "+ amountInDollorString, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDollor = (Button)findViewById(R.id.buttondollor);
        buttonRuppee = (Button)findViewById(R.id.button);
    }
}
