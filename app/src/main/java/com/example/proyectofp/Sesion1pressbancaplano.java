 package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class Sesion1pressbancaplano extends AppCompatActivity {
     //iniciar la pantalla
    Button RealizarPressBancaPlano;
    Button ContinuarPressBancaPlano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Pressbancaplano
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1pressbancaplano);
        RealizarPressBancaPlano=findViewById(R.id.BotonRealizarPressBancaPlano);
        ContinuarPressBancaPlano=findViewById(R.id.BotonContinuarPressBancaPlano);
        RealizarPressBancaPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarPressBanca = new Intent(Sesion1pressbancaplano.this, Pressbancaplano.class);
                startActivity(RealizarPressBanca);
            }
        });
        ContinuarPressBancaPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarPressbanca = new Intent(Sesion1pressbancaplano.this, Sesion1remoinclinado.class);
                startActivity(ContinuarPressbanca);
            }
        });
    }
}