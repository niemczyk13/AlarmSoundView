package com.example.alarmsoundview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.alarmsoundview.activity.SelectSoundActivity;
import com.example.alarmsoundview.view.AlarmSoundView;

public class MainActivity extends AppCompatActivity {
    private AlarmSoundView alarmSoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmSoundView = findViewById(R.id.alarm_sound_view);


    }

}