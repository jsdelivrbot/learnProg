package com.tinoromero.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void changeImgFunction(View view) {
        ImageView guitarView = (ImageView) findViewById(R.id.guitarView);
        guitarView.setImageResource(R.drawable.guitar2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
