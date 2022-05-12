package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Eliptica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliptica);
        VideoView videoview = findViewById(R.id.videoView);
        String Path = "android.resource://" + getPackageName() + "/" + R.raw.eliptica;
        Uri uri = Uri.parse(Path);
        videoview.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);
    }
}