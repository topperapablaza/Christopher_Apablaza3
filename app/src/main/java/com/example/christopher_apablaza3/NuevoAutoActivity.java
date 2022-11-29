package com.example.christopher_apablaza3;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christopher_apablaza3.modelo.AutoLista;
import com.example.christopher_apablaza3.modelo.Auto;
import com.example.christopher_apablaza3.modelo.AutosDatabaseHelper;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NuevoAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_auto);
        Button btnIngresar=(Button) findViewById(R.id.btnIngresarAuto);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarVehiculo(view);
            }
        });
    }
    public void ingresarVehiculo(View view){

        AutosDatabaseHelper helper=new AutosDatabaseHelper(this);

        String modelo=((TextView)findViewById(R.id.ingresarModelo)).getText().toString();
        String marca=((TextView)findViewById(R.id.ingresarMarca)).getText().toString();
        String matricula=((TextView)findViewById(R.id.ingresarMatricula)).getText().toString();
        String tipo=((Spinner)findViewById(R.id.ingresarTipo)).getSelectedItem().toString();
        EditText etFecha=(EditText) findViewById(R.id.etFecha);
        Object etFech=(EditText) findViewById(R.id.etFecha);
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.etFecha){
                    mostrarCalendario();
                    Object etFech=(EditText) findViewById(R.id.etFecha);
                }
            }
        });
        CheckBox favorito=(CheckBox) findViewById(R.id.favorito);
        boolean enviarF=false;
        if(favorito.isChecked())
        {
            enviarF=true;
        }
        String comprobacion="";
        String comprobacion2="tipo";
        if(comprobacion==modelo) {
            Toast.makeText(this, "Debe Ingresar el modelo del vehículo", Toast.LENGTH_SHORT).show();
        }
        else{
            if(comprobacion==marca) {
                Toast.makeText(this, "Debe Ingresar la marca del vehículo", Toast.LENGTH_SHORT).show();
            }
            else{
                if(comprobacion==matricula) {
                    Toast.makeText(this, "Debe Ingresar la matricula del vehículo", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(comprobacion==tipo || comprobacion2==tipo) {
                        Toast.makeText(this, "Debe Seleccionar el tipo de vehículo", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Auto vehiculo=new Auto(modelo,marca,matricula,tipo,etFech,enviarF);
                        AutoLista.getInstancia().agregarVehiculo(vehiculo);
                        finish();
                    }
                }
            }
        }
    }
    private void mostrarCalendario() {
        DatePickerFragment nuevoFragment=DatePickerFragment.instancia(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                final String fecha= i2 + " / " + (i1+1) + " / " + i;
                EditText etFecha=(EditText) findViewById(R.id.etFecha);
                etFecha.setText(fecha);
            }
        });
        nuevoFragment.show(getSupportFragmentManager(), "datepicker");
    }
}