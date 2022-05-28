package com.example.proyectofp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Administrar extends AppCompatActivity {

    private EditText correo, correo2, carnet, nombre, telefono;
    private Switch swAdmin;
    private Button buscar, crear, eliminar, resetear, modificar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference("message");

    private FirebaseAuth firebaseAuth;
   // private DatabaseReference databaseReference;

    private ProgressDialog progressDialog;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar);

        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference = database.getReference("Usuarios");
    //    databaseReference.setValue("Usuarios");

        // databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");

        correo=findViewById(R.id.textoCorreo);
        correo2=findViewById(R.id.textoCorreo2);
        carnet=findViewById(R.id.textoCarnet);
        swAdmin=findViewById(R.id.SwitchAdmin);
        nombre=findViewById(R.id.textoNombre);
        telefono=findViewById(R.id.textoCarnet);

        buscar=findViewById(R.id.btnBuscar);
        crear=findViewById(R.id.btnCrear);
        eliminar=findViewById(R.id.btnEliminar);
        resetear=findViewById(R.id.btnResetear);
        modificar=findViewById(R.id.btnModificar);

        progressDialog = new ProgressDialog(this);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";

                final String correoU= correo.getText().toString().trim();
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

                                    String idUnico = databaseReference.push().getKey();

                                    UsuariosDTO usuariosDTO = new UsuariosDTO(idUnico, correo2U, carnetU, estadoAdmin, nombreU, telefonoU);

                                    databaseReference.child(idUnico).setValue(usuariosDTO);

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
    }
}