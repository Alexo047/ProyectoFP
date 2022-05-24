      package com.example.proyectofp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.Principal;

      public class MainActivity extends AppCompatActivity {
          Button botonregistro;
          private EditText correo;
          private EditText contrasena;
          private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonregistro=findViewById(R.id.Registrarse);
        correo=findViewById(R.id.correo);
        contrasena=findViewById(R.id.contrasena);
        mAuth = FirebaseAuth.getInstance();
        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrar = new Intent(MainActivity.this, Registrarse.class);
                startActivity(registrar);
            }
        });
        //botonLogin = findViewById(R.id.LoginB);
    }

          public void onStart() {
              super.onStart();
              // Check if user is signed in (non-null) and update UI accordingly.
              FirebaseUser currentUser = mAuth.getCurrentUser();
          }

    public void iniciarSesion(View view){
        mAuth.signInWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Inicio de sesión correcta",
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), principal.class);
                            startActivity(i);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }



}