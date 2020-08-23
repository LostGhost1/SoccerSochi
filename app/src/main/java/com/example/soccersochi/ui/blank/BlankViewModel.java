package com.example.soccersochi.ui.blank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlankViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BlankViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is blank fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}