package com.example.soccersochi.ui.meets;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeetsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeetsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is blank fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}