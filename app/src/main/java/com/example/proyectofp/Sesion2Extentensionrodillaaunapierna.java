package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion2Extentensionrodillaaunapierna extends AppCompatActivity {

    Button BRealizarExtensionaunapierna;
    Button BContinuarExtensionaunapierna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion2_extentensionrodillaaunapierna);
        BRealizarExtensionaunapierna=findViewById(R.id.BotonRealizarExtension);
        BContinuarExtensionaunapierna=findViewById(R.id.BotonContinuarExtension);
        BRealizarExtensionaunapierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarExtension = new Intent(Sesion2Extentensionrodillaaunapierna.this, Extensionrodillaaunapiernaconmaquina.class);
                startActivity(RealizarExtension);
            }
        });
        BContinuarExtensionaunapierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarExtension = new Intent(Sesion2Extentensionrodillaaunapierna.this, Sesion2Extensionrodillasenprensa.class);
                startActivity(ContinuarExtension);
            }
        });
    }
}