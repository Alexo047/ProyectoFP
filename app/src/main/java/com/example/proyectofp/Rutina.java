package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rutina extends AppCompatActivity {

Button BotonSesion1;
Button BotonSesion2;
Button BotonSesion3;
Button BotonSesion4;
Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);
        BotonSesion1= findViewById(R.id.BSesion1);
        BotonSesion2=findViewById(R.id.BSesion2);
        BotonSesion3=findViewById(R.id.BSesion3);
        btnVolver=findViewById(R.id.Volver);
        BotonSesion4=findViewById(R.id.BSesion4);
        BotonSesion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sesion1 = new Intent(Rutina.this, Sesion1Cardio.class);
                startActivity(Sesion1);
            }
        });
        BotonSesion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sesion2 = new Intent(Rutina.this, Sesion2Cardio.class);
                startActivity(Sesion2);
            }
        });
        BotonSesion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sesion3 = new Intent(Rutina.this, Sesion3Cardio.class);
                startActivity(Sesion3);
            }
        });
        BotonSesion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sesion4 = new Intent(Rutina.this, Sesion4Cardio.class);
                startActivity(Sesion4);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Rutina.this, principal.class);
                startActivity(volver);
            }
        });
    }
}