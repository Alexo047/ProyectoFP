package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion3Ehpushups extends AppCompatActivity {
    //iniciar la pantalla

    Button BRealizarEhpushups;
    Button BContinuarEHpushups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de Ehpushups
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion3_ehpushups);
        BRealizarEhpushups=findViewById(R.id.BotonRealizarEhpush);
        BContinuarEHpushups=findViewById(R.id.BotonContinuarEhpush);
        BRealizarEhpushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarEhpush = new Intent(Sesion3Ehpushups.this, Ehpushups.class);
                startActivity(RealizarEhpush);
            }
        });
        BContinuarEHpushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarEhpush = new Intent(Sesion3Ehpushups.this, Sesion3Ehpresshorizontal.class);
                startActivity(ContinuarEhpush);
            }
        });
    }
}