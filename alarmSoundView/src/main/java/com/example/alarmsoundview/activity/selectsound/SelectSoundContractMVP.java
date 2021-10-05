package com.example.alarmsoundview.activity.selectsound;

import android.content.Intent;

public interface SelectSoundContractMVP {
    interface View {
        void updateListView();
        void setResultAndFinish(Intent intent);
        void onBackButtonPressed();
    }

    interface Presenter {
        void itemClick(int position);
        void okButtonClick();
        void cancelButtonClick();
    }
}
