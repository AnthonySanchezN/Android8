package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaContactos;
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = (ListView) findViewById(R.id.listaContactos);

        contactos = new ArrayList<>();
        contactos.add(new Contacto("Anthony", 667233966));
        contactos.add(new Contacto("Jeraldynee", 667417618));
        contactos.add(new Contacto("Gabriela", 667397521));
        contactos.add(new Contacto("Brayant", 667520993));
        contactos.add(new Contacto("Pedro", 667304105));

        ArrayList<String> nombreContactos = new ArrayList<>();

        for(Contacto contacto: contactos){
            nombreContactos.add(contacto.getNombre() + " ");
        }
        listaContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombreContactos));
        listaContactos.setOnItemClickListener((adapterView, view, posicion, l) ->{
            Intent intent = new Intent(MainActivity.this, Detalles.class);
            intent.putExtra("NombreContacto", contactos.get(posicion).getNombre());
            intent.putExtra("NumeroTelefono", contactos.get(posicion).getTelefono());
        } );




    }


}