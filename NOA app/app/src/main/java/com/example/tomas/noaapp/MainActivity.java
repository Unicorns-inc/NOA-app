package com.example.tomas.noaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.buttonToBrandPage);
    }
    public void onClickGoToBrandPage(View v)
    {
        Intent intent= new Intent(MainActivity.this,BrandPage.class);
        startActivity(intent);

    }
}
