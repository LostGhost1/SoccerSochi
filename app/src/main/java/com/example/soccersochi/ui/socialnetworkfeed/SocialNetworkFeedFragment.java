package com.example.soccersochi.ui.socialnetworkfeed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soccersochi.R;

public class SocialNetworkFeedFragment extends Fragment {


    private SocialNetworkFeedViewModel socialNetworkFeedViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        socialNetworkFeedViewModel =
                ViewModelProviders.of(this).get(SocialNetworkFeedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_socialnetwork, container, false);
        ImageView vk=root.findViewById(R.id.vkImg);
        vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/pfcsochi"));
                startActivity(browserIntent);
            }
        });
        ImageView instagram=root.findViewById(R.id.instaImg);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/pfcsochi/"));
                startActivity(browserIntent);
            }
        });
        ImageView facebook=root.findViewById(R.id.facebookImg);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pfcsochi"));
                startActivity(browserIntent);
            }
        });
        ImageView tiktok=root.findViewById(R.id.tiktokImg);
        tiktok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@pfcsochi"));
                startActivity(browserIntent);
            }
        });
        ImageView youtube=root.findViewById(R.id.youtubeImg);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC83n8-nVyTxcFdWDXOisQAA"));
                startActivity(browserIntent);
            }
        });
        ImageView twitter=root.findViewById(R.id.twitterImg);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/pfcsochi"));
                startActivity(browserIntent);
            }
        });
        return root;
    }


}