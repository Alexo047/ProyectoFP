package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Press extends AppCompatActivity {
    Button RealizarPress;
    Button ContinuarPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_press);
        RealizarPress=findViewById(R.id.BotonRealizarPress);
        ContinuarPress=findViewById(R.id.BotonContinuarPress);
        RealizarPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Press = new Intent(Sesion1Press.this, Press.class);
                startActivity(Press);
            }
        });
        ContinuarPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Press = new Intent(Sesion1Press.this, Sesion1Aperturasbancoplano.class);
                startActivity(Press);
            }
        });
    }
}