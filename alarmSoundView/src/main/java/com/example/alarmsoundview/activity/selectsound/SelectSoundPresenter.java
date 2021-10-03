package com.example.alarmsoundview.activity.selectsound;

import android.media.MediaPlayer;

import com.example.alarmsoundview.model.Sound;

public class SelectSoundPresenter implements SelectSoundContractMVP.Presenter {
    private Sound sound;
    private MediaPlayer mediaPlayer;
}
