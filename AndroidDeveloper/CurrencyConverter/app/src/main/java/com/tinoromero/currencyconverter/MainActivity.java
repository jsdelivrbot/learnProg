package com.tinoromero.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertFunction(View view) {
        EditText currencyText = (EditText) findViewById(R.id.currencyText);
        double dollars = Double.parseDouble(currencyText.getText().toString());
        double pesos = dollars * 17.76;

        Toast.makeText(this, "$" + String.format("%.2f", pesos) + " pesos.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
