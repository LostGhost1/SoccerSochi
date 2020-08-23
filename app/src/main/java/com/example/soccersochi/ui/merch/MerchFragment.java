package com.example.soccersochi.ui.merch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soccersochi.R;


public class MerchFragment extends Fragment {


    private MerchViewModel merchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        merchViewModel =
                ViewModelProviders.of(this).get(MerchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_merch, container, false);
        //final TextView textView = root.findViewById(R.id.hellomerchtextview);
         merchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}