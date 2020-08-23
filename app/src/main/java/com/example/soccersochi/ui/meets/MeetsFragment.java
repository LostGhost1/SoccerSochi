package com.example.soccersochi.ui.meets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.soccersochi.R;
import com.example.soccersochi.ui.ParsingTask;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MeetsFragment extends Fragment {


    private MeetsViewModel meetsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meetsViewModel =
                ViewModelProviders.of(this).get(MeetsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_meets, container, false);
        //final TextView textView = root.findViewById(R.id.helloblanktextview);

        meetsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
              @Override
              public void onChanged(@Nullable String s) {
                  //textView.setText(s);
              }
          });
        return root;
    }
}