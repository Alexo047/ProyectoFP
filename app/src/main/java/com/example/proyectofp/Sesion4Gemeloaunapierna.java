package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Gemeloaunapierna extends AppCompatActivity {
    //iniciar la pantalla

    Button terminars4;
    Button realizarGemelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te termina la sesion o te lleva a la explicación de Gemeloaunapierna
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_gemeloaunapierna);
        terminars4=findViewById(R.id.botonTerminarS4);
        realizarGemelo=findViewById(R.id.botonRealizarGemeloAUnaPierna);
        terminars4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terminars4 = new Intent(getApplicationContext(), principal.class);
                startActivity(terminars4);
            }
        });
        realizarGemelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gemeloAUnaPierna = new Intent(getApplicationContext(), Gemeloaunapierna.class);
                startActivity(gemeloAUnaPierna);
            }
        });
    }
}