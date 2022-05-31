package com.example.proyectofp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ajustes extends AppCompatActivity {

    Button BirIMC;
    Button btnborrar;
    Button btncambiarPass;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        DatabaseReference databaseReference = database.getReference("Usuarios");



        BirIMC=findViewById(R.id.BotonirIMC);
        btnborrar=findViewById(R.id.BotonBorrarUsuario);
        btncambiarPass=findViewById(R.id.BotonCambiarPass);
        BirIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irIMC = new Intent(Ajustes.this, CalcularIMC.class);
                startActivity(irIMC);
            }
        });
        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogoBorrar = new AlertDialog.Builder(Ajustes.this);
                dialogoBorrar.setTitle("¿Seguro que quieres su cuenta?").
                        setMessage("Al borrar este usuario se perderán todos sus datos y " +
                                "no se podrán recuperar ¿Continuar eliminando su cuenta?")
                        .setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                databaseReference.child(firebaseUser.toString()).removeValue();
                                firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful())
                                        {
                                            Intent irMain = new Intent(Ajustes.this, MainActivity.class);
                                            startActivity(irMain);
                                            Toast.makeText(Ajustes.this, "Cuenta eliminada", Toast.LENGTH_LONG).show();
                                        }else
                                        {
                                            Toast.makeText(Ajustes.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });



                            }
                        });
                dialogoBorrar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = dialogoBorrar.create();
                alertDialog.show();

            }
        });


        btncambiarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




    }
}