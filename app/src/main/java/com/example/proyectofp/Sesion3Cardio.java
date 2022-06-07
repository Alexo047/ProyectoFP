package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion3Cardio extends AppCompatActivity {
    //iniciar la pantalla

    Button BRealizarEliptica;
    Button BContinuarEliptica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de cardio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion3_cardio);
        BRealizarEliptica=findViewById(R.id.BotonRealizarEliptica);
        BContinuarEliptica=findViewById(R.id.BotonContinuarEliptica);
        BRealizarEliptica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarEliptica = new Intent(Sesion3Cardio.this, Eliptica.class);
                startActivity(RealizarEliptica);
            }
        });
        BContinuarEliptica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarCinta = new Intent(Sesion3Cardio.this, Sesion3Dominadas.class);
                startActivity(ContinuarCinta);
            }
        });
    }
}