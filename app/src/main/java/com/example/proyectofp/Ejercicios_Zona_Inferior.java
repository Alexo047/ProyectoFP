package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Ejercicios_Zona_Inferior extends AppCompatActivity {

    ImageButton BPesomuertorodillasextendidas;
    ImageButton BHipThurst;
    ImageButton BExtensionRodillaaUnaPierna;
    ImageButton BExtensionRodillaEnPrensa;
    ImageButton BSentadillaEnMultipower;
    ImageButton BZancadaHaciaAtras;
    ImageButton BGlobetSquat;
    ImageButton BGemeloAUnaPierna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_zona_inferior);
        BPesomuertorodillasextendidas=findViewById(R.id.BotonPesoMuerto);
        BHipThurst=findViewById(R.id.BotonHipThrust);
        BExtensionRodillaaUnaPierna=findViewById(R.id.BotonExtensionconbarra);
        BExtensionRodillaEnPrensa=findViewById(R.id.BotonExtensionEnPrensa);
        BSentadillaEnMultipower=findViewById(R.id.BotonSentadillaEnMultipower);
        BZancadaHaciaAtras=findViewById(R.id.BotonZancadaHaciaAtras);
        BGlobetSquat=findViewById(R.id.BotonGlobetSquat);
        BGemeloAUnaPierna=findViewById(R.id.BotonGemeloAUnaPierna);
        BPesomuertorodillasextendidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PesoMuerto = new Intent(Ejercicios_Zona_Inferior.this, Pesomuertorodillasextendidas.class);
                startActivity(PesoMuerto);
            }
        });
        BHipThurst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HipThrust = new Intent(Ejercicios_Zona_Inferior.this, Hipconbarraapoyadoenbanca.class);
                startActivity(HipThrust);
            }
        });
        BExtensionRodillaaUnaPierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExtensionRodilla = new Intent(Ejercicios_Zona_Inferior.this, Extensionrodillaaunapiernaconmaquina.class);
                startActivity(ExtensionRodilla);
            }
        });
        BExtensionRodillaEnPrensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExtensionEnPrensa = new Intent(Ejercicios_Zona_Inferior.this, Extensionrodillasenprensa.class);
                startActivity(ExtensionEnPrensa);
            }
        });
        BSentadillaEnMultipower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SentadillaEnMultipower = new Intent(Ejercicios_Zona_Inferior.this, Sentadillaenmultipower.class);
                startActivity(SentadillaEnMultipower);
            }
        });
        BZancadaHaciaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ZancadaHaciaAtras = new Intent(Ejercicios_Zona_Inferior.this, Zancadahaciaatras.class);
                startActivity(ZancadaHaciaAtras);
            }
        });
        BGlobetSquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GlobetSquat = new Intent(Ejercicios_Zona_Inferior.this, Globetsquat.class);
                startActivity(GlobetSquat);
            }
        });
        BGemeloAUnaPierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GemeloAUnaPierna = new Intent(Ejercicios_Zona_Inferior.this, Gemeloaunapierna.class);
                startActivity(GemeloAUnaPierna);
            }
        });


    }

}