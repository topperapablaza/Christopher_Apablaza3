package com.example.christopher_apablaza3.modelo;

import java.util.ArrayList;
public class AutoLista {
    private static AutoLista instancia = new AutoLista();

    private ArrayList<Auto> autoLista;
    private AutoLista(){
        autoLista=new ArrayList<>();
    }

    public static AutoLista getInstancia(){
        return instancia;
    }
    public void  agregarVehiculo(Auto auto){
        autoLista.add(auto);
    }
    public Auto getAuto(int id){
        return autoLista.get(id);
    }
    public ArrayList<Auto> getAutoLista(){
        return autoLista;
    }
    public void elimnarAuto(int id){
        autoLista.get(id);
        autoLista.remove(id);
        id--;
    }

    public void eliminarAutos(){
        for(int i=0;i<autoLista.size();i++){
                autoLista.remove(i);
                i--;
        }
    }

}
