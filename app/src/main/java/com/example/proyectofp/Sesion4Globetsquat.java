package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Globetsquat extends AppCompatActivity {

    Button BRealizarGlobet;
    Button BContinuarGlobet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_globetsquat);
        BRealizarGlobet=findViewById(R.id.BotonRealizarGlobet);
        BContinuarGlobet=findViewById(R.id.BotonContinuarGlobet);
        BRealizarGlobet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarGlobet = new Intent(Sesion4Globetsquat.this, Globetsquat.class);
                startActivity(RealizarGlobet);
            }
        });
        BContinuarGlobet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarGlobet = new Intent(Sesion4Globetsquat.this, Sesion4Gemeloaunapierna.class);
                startActivity(ContinuarGlobet);
            }
        });
    }
}