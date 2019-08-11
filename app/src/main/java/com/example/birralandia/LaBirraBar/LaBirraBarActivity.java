package com.example.birralandia.LaBirraBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.birralandia.ListCervecerias;
import com.example.birralandia.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class LaBirraBarActivity extends AppCompatActivity {

    CarouselView carouselView;
    CarouselView carouselView2;
    RelativeLayout mMenu;
    int[] NovedadesImages = {R.drawable.background_splash, R.drawable.background, R.drawable.background_birrabar};
    int[] PromoImages = {R.drawable.oferta_1, R.drawable.oferta_2, R.drawable.oferta_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_birra_bar);

        mMenu = findViewById(R.id.background_menu);
        mMenu.setVisibility(View.INVISIBLE);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(PromoImages.length);
        carouselView.setImageListener(imageListener);

        carouselView2 = (CarouselView) findViewById(R.id.CarrousenNovedad);
        carouselView2.setPageCount(NovedadesImages.length);
        carouselView2.setImageListener(imageListenerNovedades);
    }

    public void AbrirMenu(View v){
        mMenu.setVisibility(View.VISIBLE);
    }

    public void CerrarMenu(View v){
        mMenu.setVisibility(View.INVISIBLE);
    }

    public void VolverAtras(View v){
        super.onBackPressed();
    }

    public void ListadoProductos(View view){
        startActivity(new Intent(this, LaBirraBarListadoActivity.class));
        overridePendingTransition(R.anim.go_entrada, R.anim.go_salida);

    }
    public void BackToActivity(View v){
        startActivity(new Intent(this, ListCervecerias.class));
        overridePendingTransition(R.anim.entrada, R.anim.salida);
    }





    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(PromoImages[position]);
            imageView.setImageResource(PromoImages[position]);
        }
    };

    ImageListener imageListenerNovedades = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(NovedadesImages[position]);
            imageView.setImageResource(NovedadesImages[position]);
        }
    };
}
