package com.example.alarmsoundview.activity.selectsound;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alarmsoundview.R;
import com.example.alarmsoundview.model.Sound;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectSoundActivity extends AppCompatActivity implements SelectSoundContractMVP.View {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private Sound sound;
    private SelectSoundPresenter presenter;
    private SelectSoundAdapter adapter;
    private AlarmBuiltInSoundData data;
    @BindView(R.id.built_in_sound_list_view)
    protected ListView soundListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sound);
        ButterKnife.bind(this);
        addBackArrow();
        createSoundFromBundle();
        createAlarmBuiltInSoundData();
        createSelectSoundPresenter();
        createAdapterAndAddInListView();
        addOnItemClickListenerToFileListView();
    }

    private void addBackArrow() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void createAlarmBuiltInSoundData() {
        data = new AlarmBuiltInSoundData(sound.getId());
    }

    private void createSoundFromBundle() {
        Bundle bundle = getIntent().getExtras().getBundle("data");
        sound = new Sound();
        sound.setId(bundle.getInt("id"));
        sound.setPersonal(bundle.getBoolean("is_personal"));
        sound.setUri(bundle.getString("uri"));
        sound.setSoundName(bundle.getString("name"));
    }

    private void createSelectSoundPresenter() {
        presenter = new SelectSoundPresenter(this, data);
        presenter.attach(this);
    }

    private void createAdapterAndAddInListView() {
        adapter = new SelectSoundAdapter(this, data);
        soundListView.setAdapter(adapter);
    }

    private void addOnItemClickListenerToFileListView() {
        soundListView.setOnItemClickListener((adapterView, view, position, l) -> {
            presenter.itemClick(position);
        });
    }

    @Override
    public void updateListView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setResultAndFinish(Intent intent) {
        //TODO
         //intent = new Intent();
        intent.putExtra("name",  " Liczba");
        setResult(RESULT_OK, intent);


        finish();
    }

    @Override
    public void onBackButtonPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.add_new_sound_text_view)
    public void addNewSoundTextViewClick(View view) {
        //TODO
    }

    @OnClick(R.id.save_button)
    public void okButtonClick(View view) {
        presenter.okButtonClick();
    }

    @OnClick(R.id.cancel_button)
    public void cancelButtonClick(View view) {
        presenter.cancelButtonClick();
    }

    @Override
    public void onBackPressed() {
        presenter.cancelButtonClick();
    }

}