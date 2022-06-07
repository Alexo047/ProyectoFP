package com.example.proyectofp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CambiarPass extends AppCompatActivity {
    //inicia la pantalla

    EditText nuevaPass1, nuevaPass2;
    Button cambiaPass;
    //inicio el usuario de firebase
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_pass);

        nuevaPass1=findViewById(R.id.NuevaContrasena1);
        nuevaPass2=findViewById(R.id.NuevaContrasena2);
        cambiaPass=findViewById(R.id.btnNuevaPass);
        cambiaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String contrasena1= nuevaPass1.getText().toString().trim();
                final String contrasena2= nuevaPass2.getText().toString().trim();


                if(TextUtils.isEmpty(contrasena1))
                {
                    Toast.makeText(CambiarPass.this, "Debes escribir las 2 contraseñas", Toast.LENGTH_LONG).show();
                    nuevaPass1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(contrasena2))
                {
                    Toast.makeText(CambiarPass.this, "Debes escribir las 2 contraseñas", Toast.LENGTH_LONG).show();
                    nuevaPass2.requestFocus();
                    return;
                }

                if (!(contrasena1.contains(contrasena2) && contrasena2.contains(contrasena1)))
                {
                    Toast.makeText(CambiarPass.this, "Las dos contraseñas deben ser iguales", Toast.LENGTH_LONG).show();
                    nuevaPass1.requestFocus();
                    return;
                }
                //si las dos contraseñas coinciden te la cambia

                String newPassword = contrasena1;
                user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CambiarPass.this, "contraseña cambiada", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                });


            }
        });


    }
}