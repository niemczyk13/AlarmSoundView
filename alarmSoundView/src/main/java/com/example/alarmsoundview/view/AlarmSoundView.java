package com.example.alarmsoundview.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.example.alarmsoundview.R;
import com.example.alarmsoundview.activity.selectsound.SelectSoundActivity;
import com.example.alarmsoundview.model.Sound;

public class AlarmSoundView extends LinearLayout {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private Sound sound;

    private ComponentActivity componentActivity;
    private TextView description;
    private TextView soundName;
    private AlarmSoundViewBuilder alarmSoundViewBuilder;

    public AlarmSoundView(Context context) {
        super(context);
        setProperties();
    }

    public AlarmSoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setProperties();
    }

    public AlarmSoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperties();
    }

    private void setProperties() {
        this.componentActivity = (ComponentActivity) super.getContext();
        setParamsToMainLinearLayout();
        createViews();
        addOnClickMethodToViews();
        addViewsToMainLinearLayout();
        createActivityResultLauncher();
    }

    private void createActivityResultLauncher() {
        activityResultLauncher = componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        soundName.setText(data.getStringExtra("name"));
                        //TODO zapisanie obiektu Sound
                        sound = new Sound();
                        sound.setPersonal(data.getBooleanExtra("is_personal", false));
                        sound.setUri(data.getStringExtra("uri"));
                        sound.setSoundName(data.getStringExtra("sound_name"));
                    }
                });
    }

    private void addViewsToMainLinearLayout() {
        super.addView(description);
        super.addView(soundName);
    }

    private void addOnClickMethodToViews() {
        super.setOnClickListener(this::onClick);
        description.setOnClickListener(this::onClick);
        soundName.setOnClickListener(this::onClick);
    }

    private void createViews() {
        alarmSoundViewBuilder = new AlarmSoundViewBuilder(super.getContext());
        description = alarmSoundViewBuilder.getDescriptionTextView();
        soundName = alarmSoundViewBuilder.getNameTextView();
    }

    private void setParamsToMainLinearLayout() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        super.setLayoutParams(params);
        super.setOrientation(HORIZONTAL);
    }

    private void onClick(View view) {
        Intent intent = new Intent(super.getContext(), SelectSoundActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("uri", sound.getUri());
        bundle.putBoolean("is_personal", sound.isPersonal());
        intent.putExtra("data", bundle);


        activityResultLauncher.launch(intent);
    }

    public void initialize(Sound sound) {
        this.sound = sound;
        updateView();
    }

    private void updateView() {
        description.setText(R.string.alarm_sound);
        soundName.setText(sound.getName());
    }

}
