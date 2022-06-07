package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Globetsquat extends AppCompatActivity {
    //iniciar la pantalla

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te pone el video de Globetsquat
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_globetsquat);

        VideoView videoview = findViewById(R.id.videoView);
        String Path = "android.resource://" + getPackageName() + "/" + R.raw.globetsquat;
        Uri uri = Uri.parse(Path);
        videoview.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);
    }
}