package com.example.christopher_apablaza3.modelo;

import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Auto {
    private  String modelo;
    private  String marca;
    private String matricula;
    private String tipo;
    private boolean estado;
    public static final boolean UNFAVORITO=true;
    public static final boolean FAVORITO=false;
    private String uid;
    private Date fecha;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date fech = formatter.parse(String.valueOf(fecha));

    public Auto(String uid, String modelo,String marca,String matricula, String tipo, Object fech,boolean estado) throws ParseException {
        this.uid=uid;
        this.modelo=modelo;
        this.marca=marca;
        this.matricula=matricula;
        this.tipo=tipo;
        this.fecha= (Date) fech;
        this.estado = estado;
    }

    public Auto(String modelo, String marca, String matricula, String tipo) throws ParseException {
        this.modelo=modelo;
        this.marca=marca;
        this.matricula=matricula;
        this.tipo=tipo;
        this.estado = UNFAVORITO;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula =  matricula;
    }

    public void setTipo(String tipo)
    {
        this.tipo= tipo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public void setfecha(Date fecha){
        this.fecha=fecha;
    }


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo(){
        return tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getUid(){
        return uid;
    }
    public Date getFecha(){
        return fecha;
    }

    @Override
    public String toString() {
        String favorito;
        if(estado==FAVORITO){
            favorito="favorito";
        }
        else{
            favorito="no favorito";
        }
        return  matricula+": " + favorito;
    }
}
