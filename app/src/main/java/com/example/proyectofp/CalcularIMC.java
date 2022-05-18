package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularIMC extends AppCompatActivity {

    Button BIMC;
    EditText TextoALtura, TextoPeso;
    TextView TextoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);
        BIMC=findViewById(R.id.BotonIMC);
        TextoALtura=(EditText) findViewById(R.id.Altura);
        TextoPeso=(EditText) findViewById(R.id.Peso);
        TextoResultado=(TextView) findViewById(R.id.Resultado);
        BIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ValorAltura= Integer.parseInt(TextoALtura.getText().toString());
                double ValorPeso= Integer.parseInt(TextoPeso.getText().toString());
                double valorAlturaAlcuadrado= ValorAltura * ValorAltura;
                double resulFinal = ValorPeso / valorAlturaAlcuadrado;
                TextoResultado.setText("Su IMC es: "+ resulFinal);

            }
        });
    }
}