package com.example.soccersochi.ui.adapters;

import android.graphics.Bitmap;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soccersochi.News;
import com.example.soccersochi.R;
import com.example.soccersochi.DownloadImage;
import com.example.soccersochi.ui.TransferBD;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private ArrayList<News> news;
    private TransferBD parsed;

    public NewsAdapter(Context context, ArrayList<News> news, TransferBD parsed) {
        this.context = context;
        this.news = news;
        this.parsed = parsed;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        if(position>=news.size()) {
            DownloadImage task = new DownloadImage( news, context.getResources(), holder, holder.getAdapterPosition(),parsed);
            task.execute();
            return;
        }
        holder.setNews(news.get(position));
        holder.Update();
    }

    @Override
    public int getItemCount() {
        return parsed.textsArray.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private News news;
        private TextView txtName;
        private ImageView imageView;

        NewsHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.news_item_text);
            imageView = itemView.findViewById(R.id.news_item_image);
        }
        public void setNews(News news){
            this.news = news;
        }
        public void setHeadline(String headline) {
            txtName.setText(headline);
            news.headline = headline;
        }

        public void setImageBitmap(Bitmap bmp) {
            this.imageView.setImageBitmap(bmp);
            news.bitmap = bmp;
        }

        public void Update() {
            txtName.setText(news.headline);
            imageView.setImageBitmap(news.bitmap);
        }
    }
}