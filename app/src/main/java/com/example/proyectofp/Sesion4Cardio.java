package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Cardio extends AppCompatActivity {
    //iniciar la pantalla

    Button BRealizarJumping;
    Button BContinuarJumping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //te continua las sesiones o te lleva a la explicación de cardio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_cardio);
        BRealizarJumping=findViewById(R.id.BotonRealizarJumping);
        BContinuarJumping=findViewById(R.id.BotonContinuarJumping);
        BRealizarJumping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RealizarJumping = new Intent(Sesion4Cardio.this, Jumpingjacks.class);
                startActivity(RealizarJumping);
            }
        });
        BContinuarJumping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContinuarJumping = new Intent(Sesion4Cardio.this, Sesion4Sentadillaenmultipower.class);
                startActivity(ContinuarJumping);
            }
        });
    }
}