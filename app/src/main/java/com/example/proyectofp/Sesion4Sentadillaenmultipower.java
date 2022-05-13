package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Sentadillaenmultipower extends AppCompatActivity {

    Button BRealizarSentadilla;
    Button BContinuarSentadilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_sentadillaenmultipower);
        BRealizarSentadilla=findViewById(R.id.BotonRealizarSentadilla) ;
        BContinuarSentadilla=findViewById(R.id.BotonCOntinuarSentadilla);
        BRealizarSentadilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarSentadilla = new Intent(Sesion4Sentadillaenmultipower.this, Sentadillaenmultipower.class);
                startActivity(RealizarSentadilla);
            }
        });
        BContinuarSentadilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarSentadilla = new Intent(Sesion4Sentadillaenmultipower.this, Sesion4Zancadahaciaatras.class);
                startActivity(ContinuarSentadilla);
            }
        });

    }
}