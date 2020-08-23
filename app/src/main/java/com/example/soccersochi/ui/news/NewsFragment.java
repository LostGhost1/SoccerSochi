package com.example.soccersochi.ui.news;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccersochi.News;
import com.example.soccersochi.R;
import com.example.soccersochi.ui.ParsingTask;
import com.example.soccersochi.ui.TransferBD;
import com.example.soccersochi.ui.adapters.NewsAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class NewsFragment extends Fragment {


    private NewsViewModel newsViewModel;
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ArrayList<News> news = new ArrayList<News>();
        ParsingTask pt;
        //TextView block_1 = view.findViewById(R.id.block_1); //табло вывода
        pt = new ParsingTask();
        pt.execute();
        TransferBD df = null;
        try {
            df = pt.get();
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newsAdapter = new NewsAdapter(this.getContext(), news,df);
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

}