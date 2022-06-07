package com.example.proyectofp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class menu extends Fragment {
    //inicia la pantalla del menu

    private Button botonEjercicios;
    private Button botonPrincipal;
    private Button botonAjustes;


    public menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
//se crea los botones y se les asocia las pantallas

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        botonEjercicios= view.findViewById(R.id.botonEJ);
        botonPrincipal= view.findViewById(R.id.botonHome);
        botonAjustes= view.findViewById(R.id.botonPerfil);
        botonPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getActivity(), principal.class);
                getActivity().startActivity(home);

            }
        });
        botonEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ejercicios = new Intent(getActivity(), Ejercicios.class);
                getActivity().startActivity(Ejercicios);
            }
        });
        botonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Perfil = new Intent(getActivity(), Ajustes.class);
                getActivity().startActivity(Perfil);
            }
        });
    }
}