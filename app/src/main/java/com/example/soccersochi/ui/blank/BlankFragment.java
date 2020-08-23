package com.example.soccersochi.ui.blank;

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

public class BlankFragment extends Fragment {


    private BlankViewModel blankViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        blankViewModel =
                ViewModelProviders.of(this).get(BlankViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        //final TextView textView = root.findViewById(R.id.helloblanktextview);
        blankViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
              @Override
              public void onChanged(@Nullable String s) {
                  //textView.setText(s);
              }
          });
        return root;
    }
}