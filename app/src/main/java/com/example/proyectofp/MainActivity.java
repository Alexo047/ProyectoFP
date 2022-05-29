      package com.example.proyectofp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.security.Principal;

      public class MainActivity extends AppCompatActivity {
          Button botonregistro;
          private EditText correo;
          private EditText contrasena;
          private FirebaseAuth mAuth;
          //FirebaseDatabase database = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/");
          //DatabaseReference databaseReference = database.getReference("Usuarios");
          DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
          DatabaseReference usersRef = databaseReference.child("Usuarios");

          private Boolean admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonregistro=findViewById(R.id.Registrarse);
        correo=findViewById(R.id.correo);
        contrasena=findViewById(R.id.contrasena);
        mAuth = FirebaseAuth.getInstance();
/*        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrar = new Intent(MainActivity.this, Administrar.class);
                startActivity(registrar);
            }
        });*/
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
                            boolean administrador = false;
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Inicio de sesión correcta",
                                    Toast.LENGTH_SHORT).show();

                            final String correoU= correo.getText().toString().trim();
                            Query queryByEmail = usersRef.orderByChild("correo2").equalTo(correoU);
                            queryByEmail.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (task.isSuccessful()) {

                                        for (DataSnapshot ds : task.getResult().getChildren()) {
                                           // administrador = ds.child("administrador").getValue(Boolean.class);


                                        }

                                    } else {
                                        Log.d("TAG", task.getException().getMessage()); //Don't ignore potential errors!
                                    }
                                }
                            });


                            if (administrador)
                            {
                                Toast.makeText(getApplicationContext(), "Eres admin",
                                        Toast.LENGTH_LONG).show();
                            }else
                            {
                                Toast.makeText(getApplicationContext(), "No lo eres",
                                        Toast.LENGTH_LONG).show();
                            }

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