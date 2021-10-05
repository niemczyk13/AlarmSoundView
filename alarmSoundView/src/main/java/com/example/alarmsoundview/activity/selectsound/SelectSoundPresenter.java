package com.example.alarmsoundview.activity.selectsound;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.alarmsoundview.activity.BasePresenter;
import com.example.alarmsoundview.model.Sound;

public class SelectSoundPresenter extends BasePresenter<SelectSoundContractMVP.View> implements SelectSoundContractMVP.Presenter {
    private MediaPlayer player;

    private Context context;
    private AlarmBuiltInSoundData data;
    private int markedPosition;
    private boolean isPlaying = false;
    private BuiltInSound markedSound;
    private int clickPosition;

    public SelectSoundPresenter(Context context, AlarmBuiltInSoundData data) {
        this.context = context;
        this.data = data;

        markedPosition = data.getMarkedPosition();
        markedSound = data.get(markedPosition);
    }

    @Override
    public void itemClick(int position) {
        this.clickPosition = position;
        if (isClickedOtherSong()) {
            stopOldAndPlayNewSong();
        } else {
            stopOrPlayTheSameSong();
        }
    }

    private boolean isClickedOtherSong() {
        return markedPosition != clickPosition;
    }

    private void stopOldAndPlayNewSong() {
        stopMusic();
        updateUncheckedSound();
        replaceMarkedSound();
        updateMarkedSound();
        playMusic();
        view.updateListView();
    }

    private void stopMusic() {
        if (isPlaying) {
            player.stop();
            isPlaying = false;
        }
    }

    private void updateUncheckedSound() {
        markedSound.setUnchecked();
    }

    private void replaceMarkedSound() {
        markedSound = data.get(clickPosition);
        markedPosition = clickPosition;
        data.setMarkedPosition(markedPosition);
    }

    private void updateMarkedSound() {
        markedSound.setChecked();
    }

    private void playMusic() {
        if (!isPlaying) {
            player = MediaPlayer.create(context, markedSound.getId());
            player.start();
            isPlaying = true;
        }
    }

    private void stopOrPlayTheSameSong() {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    @Override
    public void okButtonClick() {
        //TODO tworzenie obiektu Sound i zwrócenie
        stopMusic();
        //String id = Integer.toString(markedSound.getId());
        //Intent intent = createIntentAndAddArgument(id);
        //view.setResultAndFinish(intent);
    }

    @Override
    public void cancelButtonClick() {
        stopPlayingSong();
        view.onBackButtonPressed();
    }

    public void stopPlayingSong() {
        if (isPlaying) {
            player.stop();
        }
    }
}
