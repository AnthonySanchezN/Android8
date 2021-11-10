package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Contacto extends AppCompatActivity {
    String nombre;
    int telefono;

    public Contacto(String nombre, int telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono(){
        return telefono;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

    }
}