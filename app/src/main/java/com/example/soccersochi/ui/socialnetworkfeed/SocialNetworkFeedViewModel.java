package com.example.soccersochi.ui.socialnetworkfeed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SocialNetworkFeedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SocialNetworkFeedViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is SocialNetworkFeed fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}