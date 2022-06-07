package com.example.proyectofp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {
    //inicia la pantalla
    Button botonPass;
    private EditText correo;
    private EditText contrasena;
    //creo objeto de autenticacion y base de datos en firebase
    private FirebaseAuth mAuth;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private String esadmin = "false";
    DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonPass = findViewById(R.id.btnResetPass);
        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        mAuth = FirebaseAuth.getInstance();

        botonPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String correoU = correo.getText().toString().trim();
                String emailAddress = correoU;


                if (TextUtils.isEmpty(correoU)) {
                    Toast.makeText(MainActivity.this, "El correo no puede estar vacío", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;

                }
                //si te has olvidado de la contraseña te envia un correo si el usuario existe
                Toast.makeText(MainActivity.this, "Correo enviado a: " + correoU, Toast.LENGTH_LONG).show();
                auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Correo enviado a: " + correoU, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();


    }

    public void iniciarSesion(View view) {
        //si el usuario existe te inicia sesion en la app

        final String correoU = correo.getText().toString().trim();
        final String password = contrasena.getText().toString().trim();

        if (TextUtils.isEmpty(correoU)) {
            Toast.makeText(MainActivity.this, "Debes escribir el correo", Toast.LENGTH_LONG).show();
            correo.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Debes escribir la contraseña", Toast.LENGTH_LONG).show();
            contrasena.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // si es admin te lleva a la administracion de usuarios, si no lo es te lleva a la pantalla principal
                            final String correoU = correo.getText().toString().trim();
                            final String correoFinal = correoU.replace(".", ",");
                            FirebaseUser user = mAuth.getCurrentUser();
                            databaseReference.child("Usuarios").child(correoFinal).child("Admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato admin", task.getException());
                                    } else {
                                        esadmin = String.valueOf(task.getResult().getValue());
                                        if (esadmin.contains("true")) {
                                            Intent admin = new Intent(getApplicationContext(), Administrar.class);
                                            startActivity(admin);

                                        } else if (esadmin.contains("false")) {
                                            Intent noadmin = new Intent(getApplicationContext(), principal.class);
                                            startActivity(noadmin);

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos",
                                                    Toast.LENGTH_LONG).show();
                                        }

                                    }
                                    correo.setText("");
                                    contrasena.setText("");
                                }
                            });

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos.",
                                    Toast.LENGTH_SHORT).show();
                            correo.setText("");
                            contrasena.setText("");
                        }
                    }
                });


    }


}