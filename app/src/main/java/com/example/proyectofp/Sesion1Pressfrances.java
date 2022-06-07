package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Pressfrances extends AppCompatActivity {
//iniciar la pantalla
    Button terminars1;
    Button RealizarPressFrances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te termina la sesion o te lleva a la explicación de cardio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_pressfrances);
        terminars1=findViewById(R.id.botonTerminarS1);
        RealizarPressFrances=findViewById(R.id.botonRealizarPressFrances);
        terminars1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terminars1 = new Intent(getApplicationContext(), principal.class);
                startActivity(terminars1);
            }
        });
        RealizarPressFrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent realizarpressFrances = new Intent(getApplicationContext(), Pressfrancesmancuerna.class);
                startActivity(realizarpressFrances);
            }
        });
    }
}