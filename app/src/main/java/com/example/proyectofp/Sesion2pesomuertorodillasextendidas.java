package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion2pesomuertorodillasextendidas extends AppCompatActivity {

    Button BRealizarPesoMuerto;
    Button BContinuarPesoMuerto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion2pesomuertorodillasextendidas);
        BRealizarPesoMuerto=findViewById(R.id.BotonRealizarPesoMuerto);
        BContinuarPesoMuerto=findViewById(R.id.BotonContinuarPesoMuerto);
        BRealizarPesoMuerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarPesoMuerto = new Intent(Sesion2pesomuertorodillasextendidas.this, Pesomuertorodillasextendidas.class);
                startActivity(RealizarPesoMuerto);
            }
        });
        BContinuarPesoMuerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarPesoMuerto = new Intent(Sesion2pesomuertorodillasextendidas.this, Sesion2Hipthrustconbarra.class);
                startActivity(ContinuarPesoMuerto);
            }
        });
    }
}