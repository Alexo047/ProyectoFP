package com.example.proyectofp;

public class UsuariosDTO {

    private String id, correo2, carnet,  nombre, telefono;
    private Boolean administrador;

    public UsuariosDTO(String id, String correo2, String carnet, Boolean administrador, String nombre, String telefono) {
        this.id = id;
        this.correo2 = correo2;
        this.carnet = carnet;
        this.administrador = administrador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getCorreo2() {
        return correo2;
    }

    public String getCarnet() {
        return carnet;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
