package com.example.soccersochi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Looper;
import android.widget.Toast;

import com.example.soccersochi.ui.TransferBD;
import com.example.soccersochi.ui.adapters.NewsAdapter;

import org.jsoup.select.Elements;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class DownloadImage extends AsyncTask<Void, Void, Integer> {
    Bitmap bitmap;
    private ArrayList<News> news;
    private final NewsAdapter.NewsHolder holder;
    private final Integer position;
    Resources res;
    TransferBD parsed;
    public DownloadImage(ArrayList<News> news, Resources res, NewsAdapter.NewsHolder holder, Integer position, TransferBD parsed){
        this.res=res;
        this.news = news;
        this.holder = holder;
        this.position = position;
        this.parsed = parsed;
    }
    @Override
    protected Integer doInBackground(Void... strings) {
        bitmap = null;
        try {
// Download Image from URL
            InputStream input = new java.net.URL(parsed.imgsArray.get(position)).openStream();
// Decode Bitmap
            bitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        news.add(new News(parsed.textsArray.get(position),bitmap, parsed.hrefsArray.get(position)));
        holder.setNews(news.get(position));
        holder.Update();
    }
}

