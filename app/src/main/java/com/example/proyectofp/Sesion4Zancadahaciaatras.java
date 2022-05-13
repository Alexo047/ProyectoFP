package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Zancadahaciaatras extends AppCompatActivity {

    Button BRealizarZancada;
    Button BContinuarZancada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_zancadahaciaatras);
        BRealizarZancada=findViewById(R.id.BotonRealizarZancada);
        BContinuarZancada=findViewById(R.id.BotonContinuarZancada);
        BRealizarZancada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarZancada = new Intent(Sesion4Zancadahaciaatras.this, Zancadahaciaatras.class);
                startActivity(RealizarZancada);
            }
        });
        BContinuarZancada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarZancada = new Intent(Sesion4Zancadahaciaatras.this, Sesion4Globetsquat.class);
                startActivity(ContinuarZancada);
            }
        });

    }
}