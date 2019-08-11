package com.example.birralandia;

import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class ListCervecerias extends FragmentActivity {

    private BottomNavigationView bottomNavigationView;

    public CardView mInicio;
    public CardView mMiCuenta;
    public CardView mBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cervecerias);

        mInicio = findViewById(R.id.Home);
        mMiCuenta = findViewById(R.id.Profile);
        mBusqueda = findViewById(R.id.Busqueda);


        RecibirCambiosNavigation();
    }

    public void RecibirCambiosNavigation(){
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        mMiCuenta.setVisibility(View.INVISIBLE);
                        mInicio.setVisibility(View.VISIBLE);
                        mBusqueda.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.action_account:
                        mInicio.setVisibility(View.INVISIBLE);
                        mMiCuenta.setVisibility(View.VISIBLE);
                        mBusqueda.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.action_search:
                        mInicio.setVisibility(View.INVISIBLE);
                        mMiCuenta.setVisibility(View.INVISIBLE);
                        mBusqueda.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_logout:
                        AuthUI.getInstance()
                                .signOut(ListCervecerias.this)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        finish();
                                    }
                                });
                        break;

                }
                return true;
            }
        });
    }

    public void CambiarMiPerfil(View View){
        Log.e("tag",""+View);
        //startActivity(new Intent(this, MiPerfil.class));
    }
}