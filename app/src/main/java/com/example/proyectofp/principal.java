package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class principal extends AppCompatActivity {
    //inicia la pantalla
    Button botonrutina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        botonrutina = findViewById(R.id.botonderutina);
        botonrutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //te lleva a la pantalla de rutina
                Intent rutina = new Intent(principal.this, Rutina.class);
                startActivity(rutina);
            }
        });
    }

}