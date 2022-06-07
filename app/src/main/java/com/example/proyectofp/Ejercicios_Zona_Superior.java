package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Ejercicios_Zona_Superior extends AppCompatActivity {
    //inicia la pantalla
    private ImageButton imagenCurl;
    private ImageButton imagenremocb;
    private ImageButton imagenbancaplano;
    private ImageButton imagenpress;
    private ImageButton imagenapertura;
    private ImageButton imagenpullover;
    private ImageButton imagenpressfrances;
    private ImageButton imagenDominada;
    private ImageButton imagenehpushup;
    private ImageButton imagenehpress;
    private ImageButton imagenremo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_zona_superior);
        imagenCurl=findViewById(R.id.ImbCurl);
        imagenremocb=findViewById(R.id.ImbRemoConBarra);
        imagenbancaplano=findViewById(R.id.ImbPressbanca);
        imagenpress=findViewById(R.id.ImbPress);
        imagenapertura=findViewById(R.id.ImbApertura);
        imagenpullover=findViewById(R.id.ImbPullover);
        imagenpressfrances=findViewById(R.id.Imbpressfrances);
        imagenehpushup=findViewById(R.id.ImbEhPush);
        imagenDominada=findViewById(R.id.ImbDominadas);
        imagenehpress=findViewById(R.id.ImbEhPress);
        imagenremo=findViewById(R.id.ImbRemoAUnaMano);
        //inicia cada pantalla de la zona superior

        imagenCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent biceps = new Intent(Ejercicios_Zona_Superior.this, Biceps.class);
                startActivity(biceps);
            }
        });
        imagenremocb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remocb = new Intent(Ejercicios_Zona_Superior.this, Remo_con_barra.class);
                startActivity(remocb);
            }
        });
        imagenbancaplano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bancaplano = new Intent(Ejercicios_Zona_Superior.this, Pressbancaplano.class);
                startActivity(bancaplano);
            }
        });
        imagenpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent press = new Intent(Ejercicios_Zona_Superior.this, Press.class);
                startActivity(press);
            }
        });
        imagenapertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apertura = new Intent(Ejercicios_Zona_Superior.this, Aperturabancoplano.class);
                startActivity(apertura);
            }
        });
        imagenpullover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pullover = new Intent(Ejercicios_Zona_Superior.this, Pulloverconmancuerna.class);
                startActivity(pullover);
            }
        });
        imagenpressfrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pressfrances = new Intent(Ejercicios_Zona_Superior.this, Pressfrancesmancuerna.class);
                startActivity(pressfrances);
            }
        });
        imagenDominada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dominada = new Intent(Ejercicios_Zona_Superior.this, Dominadas.class);
                startActivity(dominada);
            }
        });

        imagenehpushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ehpushup = new Intent(Ejercicios_Zona_Superior.this, Ehpushups.class);
                startActivity(ehpushup);
            }
        });
        imagenehpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ehpress = new Intent(Ejercicios_Zona_Superior.this, Ehpresshorizontalalternado.class);
                startActivity(ehpress);
            }
        });

        imagenremo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remo = new Intent(Ejercicios_Zona_Superior.this, Remoaunamano.class);
                startActivity(remo);
            }
        });

    }

}