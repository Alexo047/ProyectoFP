package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion3Remoaunamano extends AppCompatActivity {

    Button terminars3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion3_remoaunamano);
        terminars3=findViewById(R.id.botonTerminarS3);
        terminars3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terminars3 = new Intent(getApplicationContext(), principal.class);
                startActivity(terminars3);
            }
        });
    }
}