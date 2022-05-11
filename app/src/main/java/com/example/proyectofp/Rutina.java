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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);
        BotonSesion1= findViewById(R.id.BSesion1);
        BotonSesion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sesion1 = new Intent(Rutina.this, Sesion1Cardio.class);
                startActivity(Sesion1);
            }
        });
    }
}