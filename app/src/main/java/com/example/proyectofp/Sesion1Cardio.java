package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Cardio extends AppCompatActivity {
    Button BotonRealizarCardio;
    Button BotonContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_cardio);
        BotonRealizarCardio=findViewById(R.id.BotonRealizarBicicleta);
        BotonContinuar=findViewById(R.id.BotonContinuarBicicleta);
        BotonRealizarCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarCardio = new Intent(Sesion1Cardio.this, Bicicleta.class);
                startActivity(RealizarCardio);
            }
        });
        BotonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Continuar = new Intent(Sesion1Cardio.this, Sesion1pressbancaplano.class);
                startActivity(Continuar);
            }
        });
    }
}