package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion1Pulloverconmancuerna extends AppCompatActivity {
    //iniciar la pantalla

    Button RealizaPullover;
    Button ContinuarPullover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Pulloverconmancuerna
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1_pulloverconmancuerna);
        RealizaPullover=findViewById(R.id.BotonRealizarPullover);
        ContinuarPullover=findViewById(R.id.BotonContinuarPullover);
        RealizaPullover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Pullover = new Intent(Sesion1Pulloverconmancuerna.this, Pulloverconmancuerna.class);
                startActivity(Pullover);
            }
        });
        ContinuarPullover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Pullover = new Intent(Sesion1Pulloverconmancuerna.this, Sesion1Curlbiceps.class);
                startActivity(Pullover);
            }
        });
    }
}