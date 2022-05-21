package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
    }
    public void superior(View view)
    {
        Intent superior = new Intent(this, Ejercicios_Zona_Superior.class);
        startActivity(superior);
    }
    public void bicicleta(View view)
    {
        Intent cardio = new Intent(this, Ejercicios_Cardio.class);
        startActivity(cardio);
    }

    public void zonaInferior(View view)
    {
        Intent inferior = new Intent(this, Ejercicios_Zona_Inferior.class);
        startActivity(inferior);
    }

    public void CuerpoEntero(View view)
    {
        Intent entero = new Intent(this, Ejercicios_Cuerpo_Entero.class);
        startActivity(entero);
    }

}