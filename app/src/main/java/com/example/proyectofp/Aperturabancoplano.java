package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Aperturabancoplano extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aperturabancoplano);
        VideoView videoview = findViewById(R.id.videoView);
        String Path = "android.resource://" + getPackageName() + "/" + R.raw.aperturabancoplano;
        Uri uri = Uri.parse(Path);
        videoview.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);

    }
}