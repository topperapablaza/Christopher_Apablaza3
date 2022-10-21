package com.example.christopher_apablaza3.modelo;

public class Auto {
    private  String modelo;
    private  String marca;
    private String matricula;
    private String tipo;
    private boolean estado;

    public static final boolean UNFAVORITO=true;
    public static final boolean FAVORITO=false;

    public Auto(String modelo,String marca,String matricula, String tipo){
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
