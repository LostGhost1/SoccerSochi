package com.example.soccersochi.ui;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ParsingTask extends AsyncTask<Void, Void, TransferBD> {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected TransferBD doInBackground(Void... params) {
        Document doc = null;
        ArrayList<String> imgsArray = new ArrayList();
        ArrayList<String> hrefsArray = new ArrayList();
        ArrayList<String> textsArray = new ArrayList();
        ArrayList<String> subtextsArray = new ArrayList();


        try {
            doc = Jsoup.connect("https://pfcsochi.ru/news/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements cards = doc.select("div.row.m-0.index-news.h-100.align-content-start");

        Elements imgs = cards.select("img[src]");
        for(Element element : imgs)
            if (element != null)
                imgsArray.add("https://pfcsochi.ru" + element.select("img").first().attr("src"));

        Elements hrefs = cards.select("a[href]");
        for(Element element : hrefs)
            if (element != null)
                hrefsArray.add("https://pfcsochi.ru" + element.select("a").first().attr("href"));

        Elements texts = cards.select("div.news-item-body");
        for(Element element : texts)
            if (element != null)
                textsArray.add(element.text());

        Elements subtexts = cards.select("div.index-news-text");
        for(Element element : subtexts)
            if (element != null)
                subtextsArray.add(element.text());

        return new TransferBD(imgsArray, hrefsArray, textsArray, subtextsArray);
    }
}

