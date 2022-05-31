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
          Button botonPass;
          private EditText correo;
          private EditText contrasena;
          private FirebaseAuth mAuth;
          FirebaseAuth auth = FirebaseAuth.getInstance();
          private String esadmin = "false";
          //FirebaseDatabase database = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/");
          //DatabaseReference databaseReference = database.getReference("Usuarios");
          DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
          //DatabaseReference usersRef = databaseReference.child("Usuarios");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonPass=findViewById(R.id.btnResetPass);
        correo=findViewById(R.id.correo);
        contrasena=findViewById(R.id.contrasena);
        mAuth = FirebaseAuth.getInstance();


        botonPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String correoU= correo.getText().toString().trim();
                String emailAddress = correoU;


                if(TextUtils.isEmpty(correoU))
                {
                    Toast.makeText(MainActivity.this, "El correo no puede estar vacío", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;

                }
                Toast.makeText(MainActivity.this, "Correo enviado a: "+ correoU, Toast.LENGTH_LONG).show();
                auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Correo enviado a: "+ correoU, Toast.LENGTH_LONG).show();
                        }
                    }
                });
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

        final String correoU= correo.getText().toString().trim();
        final String password = contrasena.getText().toString().trim();

        if(TextUtils.isEmpty(correoU))
        {
            Toast.makeText(MainActivity.this, "Debes escribir el correo", Toast.LENGTH_LONG).show();
            correo.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(MainActivity.this, "Debes escribir la contraseña", Toast.LENGTH_LONG).show();
            contrasena.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            final String correoU= correo.getText().toString().trim();
                            final String correoFinal = correoU.replace(".", ",");



                            /*databaseReference.child("alex@gmail,com").addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                    Toast.makeText(getApplicationContext(), "casi dentro",
                                            Toast.LENGTH_SHORT).show();
                                    if (dataSnapshot.exists()) {

                                        esadmin = dataSnapshot.child("Admin").getValue().toString();
                                        Toast.makeText(getApplicationContext(), "dentro",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });*/

                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            //final String correoU= correo.getText().toString().trim();
                            /*Query queryByEmail = usersRef.orderByChild("correo2").equalTo(correoU);
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
                            databaseReference.child(correo2U.replace(".", ",")).setValue(personaMap);
*/
                            //databaseReference.child("alex@gmail,com")

                            databaseReference.child("Usuarios").child(correoFinal).child("Admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato admin", task.getException());
                                    }
                                    else {
                                        esadmin = String.valueOf(task.getResult().getValue());
                                        if (esadmin.contains("true"))
                                        {
                                            Intent admin = new Intent(getApplicationContext(), Administrar.class);
                                            startActivity(admin);

                                        }else if  (esadmin.contains("false"))
                                        {
                                            Intent noadmin = new Intent(getApplicationContext(), principal.class);
                                            startActivity(noadmin);

                                        }else
                                        {
                                            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos",
                                                    Toast.LENGTH_LONG).show();
                                            correo.setText("");
                                            contrasena.setText("");
                                        }

                                        //Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                    }
                                }
                            });



                            /*Toast.makeText(getApplicationContext(), "antes" + esadmin,
                                    Toast.LENGTH_LONG).show();
                            if (esadmin== "true")
                            {
                                Toast.makeText(getApplicationContext(), "Eres admin",
                                        Toast.LENGTH_LONG).show();
                            }else
                            {
                                Toast.makeText(getApplicationContext(), esadmin,
                                        Toast.LENGTH_LONG).show();

                            }*/

                            /*Intent i = new Intent(getApplicationContext(), principal.class);
                            startActivity(i);*/

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos.",
                                    Toast.LENGTH_SHORT).show();
                            correo.setText("");
                            contrasena.setText("");
                            //updateUI(null);
                        }
                    }
                });


    }



}