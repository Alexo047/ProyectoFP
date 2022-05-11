package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1remoinclinado extends AppCompatActivity {
    Button RealizarRemo;
    Button ContinuarRemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1remoinclinado);
        RealizarRemo=findViewById(R.id.BotonRealizarRemoInclinado);
        ContinuarRemo=findViewById(R.id.BotonContinuarRemoInclinado);
        RealizarRemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Remo = new Intent(Sesion1remoinclinado.this, Remo_con_barra.class);
                startActivity(Remo);
            }
        });
        ContinuarRemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Remo = new Intent(Sesion1remoinclinado.this, Sesion1Press.class);
                startActivity(Remo);
            }
        });
    }
}