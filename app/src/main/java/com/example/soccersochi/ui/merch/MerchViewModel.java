package com.example.soccersochi.ui.merch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MerchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MerchViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is Merch fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}