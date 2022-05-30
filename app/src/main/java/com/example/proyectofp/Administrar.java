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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Administrar extends AppCompatActivity {

    private EditText correo, correo2, carnet, nombre, telefono;
    private Switch swAdmin;
    private Button buscar, crear, eliminar, resetear, modificar;

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://proyectofp-23bb4-default-rtdb.europe-west1.firebasedatabase.app/");
    //DatabaseReference myRef = database.getReference("message");

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
   // private DatabaseReference databaseReference;

    private ProgressDialog progressDialog;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        DatabaseReference databaseReference = database.getReference("Usuarios");
/*        databaseReference.setValue("hola");


        databaseReference.setValue("Usuarios");*/

        // databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");

        correo=findViewById(R.id.textoCorreo);
        correo2=findViewById(R.id.textoCorreo2);
        carnet=findViewById(R.id.textoCarnet);
        swAdmin=findViewById(R.id.SwitchAdmin);
        nombre=findViewById(R.id.textoNombre);
        telefono=findViewById(R.id.textoTelefono);

        buscar=findViewById(R.id.btnBuscar);
        crear=findViewById(R.id.btnCrear);
        eliminar=findViewById(R.id.btnEliminar);
        resetear=findViewById(R.id.btnResetear);
        modificar=findViewById(R.id.btnModificar);


        correo2.setText(firebaseUser.getEmail());


        progressDialog = new ProgressDialog(this);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";


                final String correo2U= correo2.getText().toString().trim();
                final String carnetU=carnet.getText().toString().trim();
                final String nombreU=nombre.getText().toString().trim();
                final String telefonoU=telefono.getText().toString().trim();
                final String password = correo2.getText().toString().trim();
                final Boolean estadoAdmin = swAdmin.isChecked();


                //final Switch swAdmin;

                if(TextUtils.isEmpty(correo2U))
                {
                    Toast.makeText(Administrar.this, "Debes escribir el correo", Toast.LENGTH_LONG).show();
                    correo2.requestFocus();
                    return;
                }
                if(!correo2U.matches(regex)){
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
                                if (task.isSuccessful()){

                                    //String idUnico = databaseReference.push().getKey();

                                    //UsuariosDTO usuariosDTO = new UsuariosDTO(correo2U, carnetU, estadoAdmin, nombreU, telefonoU);

                                    ///databaseReference.child(correo2U).setValue(usuariosDTO);
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

                                    finish();





                                }else{

                                    Toast.makeText(Administrar.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                                }

                                progressDialog.dismiss();
                            }
                        });

                //if ()

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Administrar.this, "entrando", Toast.LENGTH_LONG).show();
                AlertDialog.Builder dialogoBorrar = new AlertDialog.Builder(Administrar.this);
                dialogoBorrar.setTitle("¿Seguro que quieres borrar el usuario?").
                        setMessage("Al borrar este usuario se perderán todos sus datos y " +
                            "no se podrán recuperar ¿Continuar eliminando el usuario?").
                                setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final String correo2U= correo2.getText().toString().trim();
                        databaseReference.child(correo2U.replace(".", ",")).removeValue();
                        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(Administrar.this, "Usuario Eliminado", Toast.LENGTH_LONG).show();
                                }else
                                {
                                    Toast.makeText(Administrar.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
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


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String correoU= correo.getText().toString().trim();
                correo2.setText(correoU);

                databaseReference.child(correoU.replace(".", ",")).child("Nombre").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {


                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error al pillar el dato admin", task.getException());
                        }
                        else {


                            String datoNombre = String.valueOf(task.getResult().getValue());
                            nombre.setText(datoNombre);


                        }




                    }
                });

                databaseReference.child(correoU.replace(".", ",")).child("Carnet").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {


                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error al pillar el dato Carnet", task.getException());
                        }
                        else {


                            String datoCarnet = String.valueOf(task.getResult().getValue());
                            carnet.setText(datoCarnet);


                        }



                    }
                });

                databaseReference.child(correoU.replace(".", ",")).child("Telefono").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {


                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error al pillar el dato Telefono", task.getException());
                        }
                        else {


                            String datoTelefono = String.valueOf(task.getResult().getValue());
                            telefono.setText(datoTelefono);


                        }

                    }
                });

                databaseReference.child(correoU.replace(".", ",")).child("Admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {


                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error al pillar el dato Admin", task.getException());
                        } else {


                            String datoAdmin = String.valueOf(task.getResult().getValue());

                            if (datoAdmin.contains("true"))
                            {
                                swAdmin.setChecked(true);

                            }else
                            {
                                swAdmin.setChecked(false);
                            }


                        }
                    }
                });






            }
        });

    }
}