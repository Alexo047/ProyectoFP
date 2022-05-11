package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion2Cardio extends AppCompatActivity {

    Button BRealizarCinta;
    Button BContinuarCinta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion2_cardio);
        BRealizarCinta=findViewById(R.id.BotonRealizarCinta);
        BContinuarCinta=findViewById(R.id.BotonContinuarCinta);
        BRealizarCinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarCinta = new Intent(Sesion2Cardio.this, Cinta.class);
                startActivity(RealizarCinta);
            }
        });
        BContinuarCinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarCinta = new Intent(Sesion2Cardio.this, Sesion2Extentensionrodillaaunapierna.class);
                startActivity(ContinuarCinta);
            }
        });
    }
}