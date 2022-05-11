package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejercicios_Zona_Inferior extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_zona_inferior);
    }
    public void pesomuertorodillasextendidas(View view)
    {
        Intent pesomuerto = new Intent(this, Pesomuertorodillasextendidas.class);
        startActivity(pesomuerto);
    }

    public void hipconbarrapoyadoenbanca(View view)
    {
        Intent hipconbarra = new Intent(this, Hipconbarraapoyadoenbanca.class);
        startActivity(hipconbarra);
    }
    public void extensionrodillaaunapierna(View view)
    {
        Intent extension = new Intent(this, Extensionrodillaaunapiernaconmaquina.class);
        startActivity(extension);
    }
    public void extensionrodillasenprensa(View view)
    {
        Intent prensa = new Intent(this, Extensionrodillasenprensa.class);
        startActivity(prensa);
    }
    public void sentadillamultipower(View view)
    {
        Intent sentadilla = new Intent(this, Sentadillaenmultipower.class);
        startActivity(sentadilla);
    }
    public void zancadahaciaatras(View view)
    {
        Intent zancada = new Intent(this, Zancadahaciaatras.class);
        startActivity(zancada);
    }
    public void globetsquat(View view)
    {
        Intent globet = new Intent(this, Globetsquat.class);
        startActivity(globet);
    }
    public void gemeloaunapierna(View view)
    {
        Intent gemelo = new Intent(this, Gemeloaunapierna.class);
        startActivity(gemelo);
    }
}