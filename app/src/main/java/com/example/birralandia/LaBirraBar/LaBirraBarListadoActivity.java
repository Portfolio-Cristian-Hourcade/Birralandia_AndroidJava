package com.example.lavaderocolores.LaBirraBar;

import android.content.Intent;
import android.os.Bundle;

import com.example.lavaderocolores.Adapter.CerveceriasAdapter;
import com.example.lavaderocolores.Adapter.ProductosAdapter;
import com.example.lavaderocolores.Model.Cervecerias;
import com.example.lavaderocolores.Model.ProductosList;
import com.example.lavaderocolores.Model.RecyclerItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.lavaderocolores.R;

import java.util.ArrayList;

public class LaBirraBarListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_birra_bar_listado);

        ArrayList<ProductosList> list = new ArrayList<ProductosList>();

        RecyclerView recyclerView = findViewById(R.id.productos_list);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        TextView aux = view.findViewById(R.id.TitleCerveceria);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        list.add(new ProductosList("La Birra Bar",R.drawable.tarjeta3));
        list.add(new ProductosList("La Birra Bar",R.drawable.tarjeta3));
        list.add(new ProductosList("La Birra Bar",R.drawable.tarjeta3));
        list.add(new ProductosList("La Birra Bar",R.drawable.tarjeta3));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ProductosAdapter(list));
    }

    public void BackToActivity(View v){
        Intent movimiento = new Intent(this, LaBirraBarActivity.class);
        startActivity(movimiento);
        finish();
        overridePendingTransition(R.anim.entrada, R.anim.salida);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
