package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion2Extensionrodillasenprensa extends AppCompatActivity {
    //iniciar la pantalla

    Button BRealizarExtensioPrensa;
    Button BContinuarExtensionPrensa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Extensionrodillasenprensa
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion2_extensionrodillasenprensa);
        BRealizarExtensioPrensa=findViewById(R.id.BotonRealizarPrensa);
        BContinuarExtensionPrensa=findViewById(R.id.BotonContinuarPrensa);
        BRealizarExtensioPrensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarExPrensa = new Intent(Sesion2Extensionrodillasenprensa.this, Extensionrodillasenprensa.class);
                startActivity(RealizarExPrensa);
            }
        });
        BContinuarExtensionPrensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarPrensa = new Intent(Sesion2Extensionrodillasenprensa.this, Sesion2pesomuertorodillasextendidas.class);
                startActivity(ContinuarPrensa);
            }
        });


    }
}