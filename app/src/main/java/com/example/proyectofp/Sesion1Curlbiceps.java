package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Curlbiceps extends AppCompatActivity {

    Button RealizarBicepsCurl;
    Button ContinuarBicepsCurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_curlbiceps);
        RealizarBicepsCurl=findViewById(R.id.BotonRealizarCurlBiceps);
        ContinuarBicepsCurl=findViewById(R.id.BotonContinuarCurlBiceps);
        RealizarBicepsCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Curl = new Intent(Sesion1Curlbiceps.this, Biceps.class);
                startActivity(Curl);
            }
        });
        ContinuarBicepsCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Curl = new Intent(Sesion1Curlbiceps.this, Sesion1Pressfrances.class);
                startActivity(Curl);
            }
        });
    }
}