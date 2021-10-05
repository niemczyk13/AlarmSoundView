package com.example.alarmsoundview.activity.selectsound;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alarmsoundview.R;

public class SelectSoundActivity extends AppCompatActivity implements SelectSoundContractMVP.View {
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sound);
        Bundle bundle = getIntent().getExtras().getBundle("data");
        String uri = bundle.getString("uri");
        TextView text = findViewById(R.id.add_new_sound_text_view);
        text.setText(uri);


        i = 1000;
        Intent intent = new Intent();
        intent.putExtra("name", i + " Liczba");
        setResult(RESULT_OK, intent);


        finish();
    }

    @Override
    public void updateListView() {
        //TODO
    }

    @Override
    public void setResultAndFinish(Intent intent) {
        //TODO
    }
}