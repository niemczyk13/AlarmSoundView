package com.example.alarmsoundview.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.example.alarmsoundview.R;

public class SelectSoundActivity extends AppCompatActivity {
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sound);
        i = 1000;
        Intent intent = new Intent();
        intent.putExtra("name", i + " Liczba");
        setResult(RESULT_OK, intent);
        finish();
    }
}