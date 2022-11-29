package com.example.christopher_apablaza3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.christopher_apablaza3.modelo.AutoLista;
import com.example.christopher_apablaza3.modelo.Auto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ListaAuto=(Button) findViewById(R.id.ver_lista);
        ListaAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Auto> autos= AutoLista.getInstancia().getAutoLista();
                if(autos.size()>0){
                    Intent intent = new Intent(MainActivity.this,ListarAutoActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "La lista de autos está vacía", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button nuevoAuto=(Button) findViewById(R.id.boton_nuevo);
        nuevoAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NuevoAutoActivity.class);
                startActivity(intent);
            }
        });
        Button eliminarAuto=(Button) findViewById(R.id.boton_eliminar);
        eliminarAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutoLista.getInstancia().eliminarAutos();
                Toast.makeText(MainActivity.this, "Se han eliminado todos los vehiculos", Toast.LENGTH_SHORT).show();
            }
        });
        Button Mapa=(Button) findViewById(R.id.boton_mapa);
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapaUmag.class);
                startActivity(intent);
            }
        });
    }
}