package com.tinoromero.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int guessNumber;

    public void makeToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void guessFunction(View view) {
        EditText sayNumber = (EditText) findViewById(R.id.editText);
        int number = Integer.parseInt(sayNumber.getText().toString());

        if(guessNumber > number) {
            makeToast("Higher!");
        } else if(guessNumber < number) {
            makeToast("Lower!");
        } else {
            makeToast("That's right! Try Again!");
            guessNumber = 1 + (int)(Math.random() * 20);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessNumber = 1 + (int)(Math.random() * 20);
    }
}
