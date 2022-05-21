package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Ejercicios_Cardio extends AppCompatActivity {

    ImageButton Bbicicleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_cardio);
        Bbicicleta=findViewById(R.id.ImagenBicicleta);
        Bbicicleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bicicleta = new Intent(Ejercicios_Cardio.this, Bicicleta.class);
                startActivity(bicicleta);
            }
        });
    }
}