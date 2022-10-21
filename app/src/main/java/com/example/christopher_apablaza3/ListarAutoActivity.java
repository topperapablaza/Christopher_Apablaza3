package com.example.christopher_apablaza3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.app.ListActivity;

import com.example.christopher_apablaza3.modelo.AutoLista;
import com.example.christopher_apablaza3.modelo.Auto;

public class ListarAutoActivity extends ListActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista(){
        lista=getListView();
        ArrayList<Auto> vehiculos= AutoLista.getInstancia().getAutoLista();
        ArrayAdapter<Auto> listaAdapter=new ArrayAdapter<Auto>(
                this, android.R.layout.simple_list_item_1,
                vehiculos
        );
        lista.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id){
        Intent intent= new Intent(ListarAutoActivity.this, DetallesActivity.class);
        intent.putExtra("idAuto",(int)id);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                cargarLista();
            }
        }
    }
}