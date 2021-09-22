package com.example.alarmsoundview.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alarmsoundview.activity.SelectSoundActivity;
import com.example.alarmsoundview.model.Sound;

public class AlarmSoundView extends LinearLayout {
    public static int REQUEST_CODE = 123;
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private static int i = 0;
    private Context context;
    private ComponentActivity componentActivity;
    private TextView description;
    private TextView soundName;
    private OnActivityResultListener onActivityResultListener;

    public AlarmSoundView(Context context) {
        super(context);
        setProperties(context);
    }

    public AlarmSoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setProperties(context);
    }

    public AlarmSoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperties(context);
    }

    private void setProperties(Context context) {
        this.context = context;
        this.componentActivity = (ComponentActivity) context;
        description = new TextView(context);
        soundName = new TextView(context);
        super.setOnClickListener(this::onClick);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        super.setLayoutParams(params);
        description.setOnClickListener(this::onClick);
        soundName.setOnClickListener(this::onClick);

        description.setText("TEST1");
        soundName.setText("TEST2");

        activityResultLauncher = componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            soundName.setText(data.getStringExtra("name"));
                        }
                    }
                });

        super.addView(description);
        super.addView(soundName);
        super.setOrientation(HORIZONTAL);


    }

    private void onClick(View view) {
        Intent intent = new Intent(context, SelectSoundActivity.class);
        activityResultLauncher.launch(intent);
        /*

        componentActivity.startActivityForResult(intent, REQUEST_CODE);
        soundName.setText("KLIK " + i++);

         */
    }

    public void initialize(Sound sound) {
        //TODO dodanie nazwy
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == componentActivity.RESULT_OK) {
            soundName.setText(data.getStringExtra("name"));
        }
    }

 */

    public interface AlarmSoundViewClickListener {
        void onClick(AppCompatActivity activity);
    }

    public void addOnActivityResultListener(OnActivityResultListener onActivityResultListener) {
        this.onActivityResultListener = onActivityResultListener;
    }

    public interface OnActivityResultListener {
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

}
