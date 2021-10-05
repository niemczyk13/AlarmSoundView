package com.example.alarmsoundview.activity.selectsound;

import android.media.MediaPlayer;

import com.example.alarmsoundview.model.Sound;

public class SelectSoundPresenter implements SelectSoundContractMVP.Presenter {
    private Sound sound;
    private MediaPlayer mediaPlayer;
    private AlarmBuiltInSoundData data;

    private int markedPosition;
    private boolean isPlaying = false;
    private Sound markedSound;
    private int clickPosition;

    @Override
    public void itemClick(int position) {
        //TODO
    }

    @Override
    public void okButtonClick() {
        //TODO
    }

    @Override
    public void stopPlayingSong() {
        //TODO
    }
}
