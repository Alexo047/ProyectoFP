package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Ejercicios_Cardio extends AppCompatActivity {

    ImageButton Bbicicleta;
    ImageButton Bcinta;
    ImageButton Beliptica;
    ImageButton BJumping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_cardio);
        Bbicicleta=findViewById(R.id.ImagenBicicleta);
        Bcinta=findViewById(R.id.ImagenCinta);
        Beliptica=findViewById(R.id.ImagenEliptica);
        BJumping=findViewById(R.id.ImagenJumping);
        Bbicicleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bicicleta = new Intent(Ejercicios_Cardio.this, Bicicleta.class);
                startActivity(bicicleta);
            }
        });
        Bcinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cinta = new Intent(Ejercicios_Cardio.this, Cinta.class);
                startActivity(cinta);
            }
        });
        Beliptica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eliptica = new Intent(Ejercicios_Cardio.this, Eliptica.class);
                startActivity(eliptica);
            }
        });
        BJumping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumping = new Intent(Ejercicios_Cardio.this, Jumpingjacks.class);
                startActivity(jumping);
            }
        });
    }
}