package com.example.birralandia.Model;



public class ProductosList {
    private String mTitulo;
    private int mBackground;


    public ProductosList(String Titulo,  int Background){
        mTitulo = Titulo;
        mBackground = Background;
    }

    public String getTitulo(){
        return mTitulo;
    }

    public int getmBackground(){
        return mBackground;
    }

}
