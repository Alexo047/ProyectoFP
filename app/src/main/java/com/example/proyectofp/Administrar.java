package com.example.proyectofp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Administrar extends AppCompatActivity {

    //Empieza la pantalla

    private EditText correo, correo2, carnet, nombre, telefono;
    private Switch swAdmin;
    private Button buscar, crear, eliminar, entrarApp, modificar;

    //creo un objeto de autenticación y de base de datos
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/");
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    Boolean existe = true;

    private ProgressDialog progressDialog;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        DatabaseReference databaseReference = database.getReference("Usuarios");


        correo = findViewById(R.id.textoCorreo);
        correo2 = findViewById(R.id.textoCorreo2);
        carnet = findViewById(R.id.textoCarnet);
        swAdmin = findViewById(R.id.SwitchAdmin);
        nombre = findViewById(R.id.textoNombre);
        telefono = findViewById(R.id.textoTelefono);

        buscar = findViewById(R.id.btnBuscar);
        crear = findViewById(R.id.btnCrear);
        eliminar = findViewById(R.id.btnEliminar);
        entrarApp = findViewById(R.id.btnEntrarApp);
        modificar = findViewById(R.id.btnModificar);


        progressDialog = new ProgressDialog(this);

        // código para crear usuarios
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";


                final String correo2U = correo2.getText().toString().trim();
                final String carnetU = carnet.getText().toString().trim();
                final String nombreU = nombre.getText().toString().trim();
                final String telefonoU = telefono.getText().toString().trim();
                final String password = correo2.getText().toString().trim();
                final Boolean estadoAdmin = swAdmin.isChecked();

                if (TextUtils.isEmpty(correo2U)) {
                    Toast.makeText(Administrar.this, "Debes escribir el correo", Toast.LENGTH_LONG).show();
                    correo2.requestFocus();
                    return;
                }
                if (!correo2U.matches(regex)) {
                    Toast.makeText(Administrar.this, "Formato de correo incorrecto", Toast.LENGTH_LONG).show();
                    correo2.requestFocus();
                    return;
                }

                progressDialog.setMessage("Creando ususario");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(correo2U, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Mapeo de los usuarios
                                    Map<String, Object> personaMap = new HashMap<>();
                                    personaMap.put("Carnet", carnetU);
                                    personaMap.put("Admin", estadoAdmin.toString());
                                    personaMap.put("Nombre", nombreU);
                                    personaMap.put("Telefono", telefonoU);

                                    databaseReference.child(correo2U.replace(".", ",")).setValue(personaMap);

                                    Toast.makeText(Administrar.this, "Registo exitoso", Toast.LENGTH_LONG).show();
                                    correo2.setText("");
                                    carnet.setText("");
                                    nombre.setText("");
                                    telefono.setText("");
                                    swAdmin.setChecked(false);


                                } else {

                                    Toast.makeText(Administrar.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                                }

                                progressDialog.dismiss();
                            }
                        });


            }
        });

        //elimina los usuarios
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String correo2U = correo2.getText().toString().trim();
                final String correoU = correo.getText().toString().trim();

                if (TextUtils.isEmpty(correo2U)) {
                    Toast.makeText(Administrar.this, "Debes escribir el correo para eliminarlo", Toast.LENGTH_LONG).show();
                    correo2.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(correoU)) {
                    Toast.makeText(Administrar.this, "Debes buscar el correo", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;
                }

                if (!(correoU.contains(correo2U) && correo2U.contains(correoU))) {
                    Toast.makeText(Administrar.this, "Los correos no coinciden", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;
                }
                //Mensaje de alerta para borrar los usuarios
                AlertDialog.Builder dialogoBorrar = new AlertDialog.Builder(Administrar.this);
                dialogoBorrar.setTitle("¿Seguro que quieres borrar el usuario?").
                        setMessage("Al borrar este usuario se perderán todos sus datos y " +
                                "no se podrán recuperar ¿Continuar eliminando el usuario?").
                        setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                databaseReference.child(correo2U.replace(".", ",")).removeValue();
                                Toast.makeText(Administrar.this, "Usuario Eliminado", Toast.LENGTH_LONG).show();


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
        // Busca los usuarios
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String correoU = correo.getText().toString().trim();

                if (TextUtils.isEmpty(correoU)) {
                    Toast.makeText(Administrar.this, "El correo no puede estar vacío", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;
                }
                //mira si el usuario existe
                databaseReference.child(correoU.replace(".", ",")).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (!snapshot.exists()) {
                            Toast.makeText(Administrar.this, "El usuario no existe", Toast.LENGTH_LONG).show();
                            existe = false;
                            correo2.setText("");
                            carnet.setText("");
                            nombre.setText("");
                            telefono.setText("");
                            swAdmin.setChecked(false);


                        } else {
                            //si el usuario existe te pilla los datos
                            correo2.setText(correoU);
                            //pilla nombre
                            databaseReference.child(correoU.replace(".", ",")).child("Nombre").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {


                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato admin", task.getException());
                                    } else {


                                        String datoNombre = String.valueOf(task.getResult().getValue());
                                        nombre.setText(datoNombre);


                                    }


                                }
                            });
                            //pilla carnet
                            databaseReference.child(correoU.replace(".", ",")).child("Carnet").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {


                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato Carnet", task.getException());
                                    } else {


                                        String datoCarnet = String.valueOf(task.getResult().getValue());
                                        carnet.setText(datoCarnet);


                                    }


                                }
                            });
                            // pilla telefono
                            databaseReference.child(correoU.replace(".", ",")).child("Telefono").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {


                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato Telefono", task.getException());
                                    } else {


                                        String datoTelefono = String.valueOf(task.getResult().getValue());
                                        telefono.setText(datoTelefono);


                                    }

                                }
                            });
                            //pilla admin
                            databaseReference.child(correoU.replace(".", ",")).child("Admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {


                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error al pillar el dato Admin", task.getException());
                                    } else {


                                        String datoAdmin = String.valueOf(task.getResult().getValue());

                                        if (datoAdmin.contains("true")) {
                                            swAdmin.setChecked(true);

                                        } else {
                                            swAdmin.setChecked(false);
                                        }


                                    }
                                }
                            });
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
        //modifica los usuarios
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String correoU = correo.getText().toString().trim();
                final String correo2U = correo2.getText().toString().trim();
                final String carnetU = carnet.getText().toString().trim();
                final String nombreU = nombre.getText().toString().trim();
                final String telefonoU = telefono.getText().toString().trim();
                final String password = correo2.getText().toString().trim();
                final Boolean estadoAdmin = swAdmin.isChecked();

                if (TextUtils.isEmpty(correo2U)) {
                    Toast.makeText(Administrar.this, "Debes escribir el correo para buscarlo", Toast.LENGTH_LONG).show();
                    correo2.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(correoU)) {
                    Toast.makeText(Administrar.this, "Debes escribir el correo", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;
                }

                if (!(correoU.contains(correo2U) && correo2U.contains(correoU))) {
                    Toast.makeText(Administrar.this, "Para cambiar un correo hay que eliminar el usuario", Toast.LENGTH_LONG).show();
                    correo.requestFocus();
                    return;
                }


                Map<String, Object> personaMap = new HashMap<>();
                personaMap.put("Carnet", carnetU);
                personaMap.put("Admin", estadoAdmin.toString());
                personaMap.put("Nombre", nombreU);
                personaMap.put("Telefono", telefonoU);
                //los modifica con el comnado updateChildren
                databaseReference.child(correo2U.replace(".", ",")).updateChildren(personaMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Administrar.this, "Datos cambiados", Toast.LENGTH_LONG).show();
                        correo2.setText("");
                        carnet.setText("");
                        nombre.setText("");
                        telefono.setText("");
                        swAdmin.setChecked(false);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Administrar.this, "El usuario no existe", Toast.LENGTH_LONG).show();
                        correo2.setText("");
                        carnet.setText("");
                        nombre.setText("");
                        telefono.setText("");
                        swAdmin.setChecked(false);
                    }
                });


            }
        });

        entrarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent entrarApp = new Intent(getApplicationContext(), principal.class);
                startActivity(entrarApp);
            }
        });

    }
}