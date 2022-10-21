package com.example.christopher_apablaza3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christopher_apablaza3.modelo.AutoLista;
import com.example.christopher_apablaza3.modelo.Auto;

public class DetallesActivity extends AppCompatActivity {
    public Auto vehiculo;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idAuto");
        vehiculo= AutoLista.getInstancia().getAuto(id);

        TextView txtModelo=(TextView) findViewById(R.id.txtModelo);
        txtModelo.setText(vehiculo.getModelo());

        TextView txtMarca=(TextView) findViewById(R.id.txtMarca);
        txtMarca.setText(vehiculo.getModelo());

        TextView txtMatricula=(TextView) findViewById(R.id.txtMatricula);
        txtMatricula.setText(vehiculo.getModelo());

        TextView txtTipo=(TextView) findViewById(R.id.txtTipo);
        txtTipo.setText(vehiculo.getModelo());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);

        if(vehiculo.isEstado()==Auto.FAVORITO){
            txtEstado.setText("Favorito");
            estado.setText("Marcar como no favorito");
        }
        else{
            txtEstado.setText("No Favorito");
            estado.setText("Marcar como favorito");
        }
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vehiculo.setEstado(!vehiculo.isEstado());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Button eliminarAuto=(Button) findViewById(R.id.boton_eliminar);
        eliminarAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutoLista.getInstancia().elimnarAuto(id);
                Toast.makeText(DetallesActivity.this, "Se ha eliminado el Vehiculo", Toast.LENGTH_SHORT).show();
            }
        });

    }
}