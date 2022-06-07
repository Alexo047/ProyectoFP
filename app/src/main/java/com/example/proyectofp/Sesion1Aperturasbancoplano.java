package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Aperturasbancoplano extends AppCompatActivity {
    //inicia la pantalla

    Button RealizarAperturas;
    Button ContinuarAperturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Aperturabancoplano
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_aperturasbancoplano);
        RealizarAperturas=findViewById(R.id.BotonRealizarAperturas);
        ContinuarAperturas=findViewById(R.id.BotonContinuarAperturas);
        RealizarAperturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aperturas = new Intent(Sesion1Aperturasbancoplano.this, Aperturabancoplano.class);
                startActivity(Aperturas);
            }
        });
        ContinuarAperturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aperturas = new Intent(Sesion1Aperturasbancoplano.this, Sesion1Pulloverconmancuerna.class);
                startActivity(Aperturas);
            }
        });
    }
}