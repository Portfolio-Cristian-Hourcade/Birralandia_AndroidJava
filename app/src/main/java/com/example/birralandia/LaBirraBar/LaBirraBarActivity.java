package com.example.birralandia.LaBirraBar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.birralandia.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class LaBirraBarActivity extends AppCompatActivity {
    CarouselView carouselView;
    CarouselView carouselView2;

    int[] NovedadesImages = {R.drawable.background_splash, R.drawable.background, R.drawable.background_birrabar};
    int[] PromoImages = {R.drawable.oferta_1, R.drawable.oferta_2, R.drawable.oferta_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_birra_bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
              getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(PromoImages.length);
        carouselView.setImageListener(imageListener);

        carouselView2 = (CarouselView) findViewById(R.id.CarrousenNovedad);
        carouselView2.setPageCount(NovedadesImages.length);
        carouselView2.setImageListener(imageListenerNovedades);
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
