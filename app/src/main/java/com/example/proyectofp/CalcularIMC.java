package com.example.proyectofp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcularIMC extends AppCompatActivity {
    //inicia la pantalla

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
                //te hace la operación de IMC
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                float ValorAltura= Integer.parseInt(TextoALtura.getText().toString());
                float ValorPeso= Integer.parseInt(TextoPeso.getText().toString());
                float valorAlturaMetros= ValorAltura / 100;
                float valorAlturaAlcuadrado= valorAlturaMetros * valorAlturaMetros;
                float resulFinal = ValorPeso / valorAlturaAlcuadrado;
                String FinalIMC = decimalFormat.format(resulFinal);
                TextoResultado.setText("Su IMC es: "+ FinalIMC);

            }
        });
    }
}