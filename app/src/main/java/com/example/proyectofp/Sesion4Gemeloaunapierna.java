package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion4Gemeloaunapierna extends AppCompatActivity {

    Button terminars4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion4_gemeloaunapierna);
        terminars4=findViewById(R.id.botonTerminarS4);
        terminars4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terminars4 = new Intent(getApplicationContext(), principal.class);
                startActivity(terminars4);
            }
        });
    }
}