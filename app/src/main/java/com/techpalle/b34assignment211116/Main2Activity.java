package com.techpalle.b34assignment211116;

import com.google.android.youtube.player.YouTubeBaseActivity;

import  android.content.Intent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main2Activity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {
    YouTubePlayerView youTubePlayerView;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtubeview);
        youTubePlayerView.initialize("AIzaSyCzQdpjLELN9vD2GoyHaYwaXh-0lBG4NDg",this);
        Intent in=getIntent();
        Bundle b=in.getExtras();
        url=b.getString("key1");
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("url");

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
