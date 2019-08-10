package com.example.birralandia.Model;

import android.graphics.Bitmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cervecerias {
    private String mTitulo;
    private String mUbicacion;
    private int mBackground;
    private int mLogo;

    public Cervecerias(String Titulo, String Ubicacion, int Background, int Logo){
        mTitulo = Titulo;
        mUbicacion = Ubicacion;
        mBackground = Background;
        mLogo = Logo;
    }

    public String getTitulo(){
        return mTitulo;
    }

    public String getUbicacion(){
        return mUbicacion;
    }

    public int getmBackground(){
        return mBackground;
    }

    public int getmLogo(){
        return mLogo;
    }
}
