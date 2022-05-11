      package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.Principal;

      public class MainActivity extends AppCompatActivity {

    private Button botonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonLogin = findViewById(R.id.LoginB);
    }
    public void login (View view)
    {
        Intent login = new Intent(this, principal.class);
        startActivity(login);
    }

}