package com.example.alarmsoundview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.alarmsoundview.model.Sound;
import com.example.alarmsoundview.view.AlarmSoundView;

public class MainActivity extends AppCompatActivity {
    private AlarmSoundView alarmSoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmSoundView = findViewById(R.id.alarm_sound_view);
        Sound sound = new Sound();
        sound.setSoundName("Piosenka");
        sound.setUri("uri/urrri");
        sound.setPersonal(false);
        alarmSoundView.initialize(sound);

    }

}