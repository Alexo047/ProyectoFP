package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion3Ehpresshorizontal extends AppCompatActivity {

    Button BRealizarEhpress;
    Button BContinuarEHpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion3_ehpresshorizontal);
        BRealizarEhpress=findViewById(R.id.BotonRealizarEhpress);
        BContinuarEHpress=findViewById(R.id.BotonContinuarEhpress);
        BRealizarEhpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarEhpress = new Intent(Sesion3Ehpresshorizontal.this, Ehpresshorizontalalternado.class);
                startActivity(RealizarEhpress);
            }
        });
        BContinuarEHpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarEhpress = new Intent(Sesion3Ehpresshorizontal.this, Sesion3Remoaunamano.class);
                startActivity(ContinuarEhpress);
            }
        });
    }
}