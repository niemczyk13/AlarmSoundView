package com.example.alarmsoundview.activity.sound.select;

import com.example.alarmsoundview.R;

import java.util.ArrayList;
import java.util.List;

public class AlarmBuiltInSoundData {
    //private static AlarmBuiltInSoundData alarmBuiltInSoundData;
    private List<BuiltInSound> sounds;
    private int markedPosition = 0;

    public AlarmBuiltInSoundData(int soundId) {
        sounds = new ArrayList<>();
        sounds.add(new BuiltInSound("Pierwszy", R.raw.closer));
        sounds.add(new BuiltInSound("Drugi", R.raw.creep));

        //TODO obliczenie pozycji na podstawie ID
        if (soundId != 0) {
            for (int i = 0; i < sounds.size(); i++) {
                if (sounds.get(i).getId() == soundId) {
                    markedPosition = i;
                    break;
                }
            }
        } else {
            markedPosition = 0;
        }
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
