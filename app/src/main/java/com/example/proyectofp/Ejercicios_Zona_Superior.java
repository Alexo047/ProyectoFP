package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ejercicios_Zona_Superior extends AppCompatActivity {
    private ImageView imagenCurl;
    private ImageView imagenremocb;
    private ImageView imagenbancaplano;
    private ImageView imagenpress;
    private ImageView imagenapertura;
    private ImageView imagenpullover;
    private ImageView imagenpressfrances;
    private ImageView imagenDominada;
    private ImageView imagenehpushup;
    private ImageView imagenehpress;
    private ImageView imagenremo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_zona_superior);
        imagenCurl=findViewById(R.id.imageView2);
        /*imagenCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent biceps = new Intent(String.valueOf(Biceps.class));
                startActivity(biceps);
            }
        });*/
    }

    public void biceps(View view) {
        Intent biceps = new Intent(this, Biceps.class);
        startActivity(biceps);
    }


    public void remoconbarra(View view) {
        Intent remocb = new Intent(this, Remo_con_barra.class);
        startActivity(remocb);
    }

    public void pressbancaplano(View view) {
        Intent bancaplano = new Intent(this, Pressbancaplano.class);
        startActivity(bancaplano);
    }

    public void press(View view) {
        Intent press = new Intent(this, Press.class);
        startActivity(press);
    }
    public void aperturabancoplano(View view) {
        Intent apertura = new Intent(this, Aperturabancoplano.class);
        startActivity(apertura);
    }
    public void pullovermancuerna(View view) {
        Intent pullover = new Intent(this, Pulloverconmancuerna.class);
        startActivity(pullover);
    }
    public void pressfrances(View view) {
        Intent pressfrances = new Intent(this, Pressfrancesmancuerna.class);
        startActivity(pressfrances);
    }
    public void dominadas(View view) {
        Intent dominada = new Intent(this, Dominadas.class);
        startActivity(dominada);
    }
    public void ehpushup(View view) {
        Intent ehpushup = new Intent(this, Ehpushups.class);
        startActivity(ehpushup);
    }

    public void ehpresshorizontal(View view) {
        Intent ehpress = new Intent(this, Ehpresshorizontalalternado.class);
        startActivity(ehpress);
    }
    public void remoaunamano(View view) {
        Intent remo = new Intent(this, Remoaunamano.class);
        startActivity(remo);
    }
}