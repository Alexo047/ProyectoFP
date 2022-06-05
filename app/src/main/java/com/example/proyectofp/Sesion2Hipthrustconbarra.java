package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion2Hipthrustconbarra extends AppCompatActivity {

    Button terminars2;
    Button RealizarHipThrust;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion2_hipthrustconbarra);
        terminars2=findViewById(R.id.botonTerminarS2);
        RealizarHipThrust=findViewById(R.id.botonRealizarPressHipThrust);
        terminars2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terminars2 = new Intent(getApplicationContext(), principal.class);
                startActivity(terminars2);
            }
        });
        RealizarHipThrust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HipThhrust = new Intent(getApplicationContext(), Hipconbarraapoyadoenbanca.class);
                startActivity(HipThhrust);
            }
        });
    }
}