package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion3Dominadas extends AppCompatActivity {
    //iniciar la pantalla

    Button BRealizarDominadas;
    Button BContinuarDominadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Dominadas
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion3_dominadas);
        BRealizarDominadas=findViewById(R.id.BotonRealizarDominadas);
        BContinuarDominadas=findViewById(R.id.BotonContinuarDominadas);
        BRealizarDominadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarDominadas = new Intent(Sesion3Dominadas.this, Dominadas.class);
                startActivity(RealizarDominadas);
            }
        });
        BContinuarDominadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarDominadas = new Intent(Sesion3Dominadas.this, Sesion3Ehpushups.class);
                startActivity(ContinuarDominadas);
            }
        });
    }
}