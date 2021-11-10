package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Detalles extends AppCompatActivity {
    TextView tvNombre, tvTelefono;
    RelativeLayout relativeLayout;
    Button button;
    int telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("NombreContacto");
        telefono = bundle.getInt("TelefonoContacto");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        button = (Button) findViewById(R.id.button);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlCall);

        tvNombre.setText(nombre);
        tvTelefono.setText(""+telefono);

        relativeLayout.setOnClickListener((view -> {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("Tel: "+telefono));
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(Detalles.this, "No hay permisos",Toast.LENGTH_LONG).show();
                return;
            }
            startActivity(intent);
        }));
    }

    public void llamar(View view){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+telefono));
        if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(Detalles.this, "No hay permisos de llamadas", Toast.LENGTH_SHORT).show();
        return;
        }
        startActivity(intent);
    }

}