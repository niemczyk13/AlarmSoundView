package com.example.alarmsoundview.activity.selectsound;

import java.util.ArrayList;
import java.util.List;

public class AlarmBuiltInSoundData {
    //private static AlarmBuiltInSoundData alarmBuiltInSoundData;
    private List<BuiltInSound> sounds;
    private int markedPosition;

    public AlarmBuiltInSoundData(int soundPosition) {
        sounds = new ArrayList<>();
        //TODO tutaj dodanie do listy utworów

        markedPosition = soundPosition;
        sounds.get(markedPosition).setChecked();
    }

    public int getSize() {
        return sounds.size();
    }

    public BuiltInSound get(int position) {
        return sounds.get(position);
    }

    public int getMarkedPosition() {
        return markedPosition;
    }

    public void setMarkedPosition(int markedPosition) {
        this.markedPosition = markedPosition;
    }
}
