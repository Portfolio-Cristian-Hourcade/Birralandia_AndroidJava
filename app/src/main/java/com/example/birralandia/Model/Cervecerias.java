package com.example.lavaderocolores.Model;

import android.graphics.Bitmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cervecerias {

    private String mTitulo;

    private String mRanking;
    private String mUbication;
    private String mTipo;

    private int mLogo;

    public Cervecerias(String Titulo, String ubicacion, int Logo, String Ranking, String Tipo){
        mTitulo = Titulo;
        mLogo = Logo;
        mRanking = Ranking;
        mTipo = Tipo;
        mUbication = ubicacion;
    }


    public String getRanking(){ return mRanking; }

    public String getTipo(){ return mTipo; }

    public String getTitulo(){
        return mTitulo;
    }

    public String getUbicacion(){
        return mUbication;
    }

    public int getmLogo(){
        return mLogo;
    }
}
