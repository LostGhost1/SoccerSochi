package com.example.soccersochi;

        import android.graphics.Bitmap;
        import android.widget.ImageView;

public class News {
    public Bitmap bitmap;
    public String headline;
    public String hreaf;

    public News(String headline, Bitmap bitmap, String hreaf){
        this.headline=headline;
        this.bitmap=bitmap;
        this.hreaf = hreaf;
    }
}
