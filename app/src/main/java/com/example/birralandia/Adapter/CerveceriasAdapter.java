package com.example.lavaderocolores.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lavaderocolores.Model.Cervecerias;
import com.example.lavaderocolores.R;

import org.w3c.dom.Text;

import java.util.List;

public class CerveceriasAdapter extends
        RecyclerView.Adapter<CerveceriasAdapter.ViewHolder> {


    @Override
    public CerveceriasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.card_item2, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CerveceriasAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Cervecerias _Cervecerias = mCervecerias.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.Title;
        textView.setText(_Cervecerias.getTitulo());

        TextView ubicacion = viewHolder.Ubication;
        ubicacion.setText(_Cervecerias.getUbicacion());


        ImageView _Logo = viewHolder.Logo;
        _Logo.setImageResource(_Cervecerias.getmLogo());

        TextView _RankingPorcentaje = viewHolder.RankingPorcentaje;
        _RankingPorcentaje.setText(_Cervecerias.getRanking());

        TextView Tipo = viewHolder.Tipo;
        Tipo.setText(_Cervecerias.getTipo());

        ImageView feliz = viewHolder.staticFelicidad;
        feliz.setImageResource(R.drawable.laugh);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCervecerias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView Title;
        public TextView Ubication;
        public ImageView Logo;
        public TextView Tipo;
        public TextView RankingPorcentaje;
        public ImageView staticFelicidad;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.title_birra);
            Ubication = (TextView) itemView.findViewById(R.id.ubicacion_birra);
            Logo = (ImageView) itemView.findViewById(R.id.logo_birra);
            Tipo = itemView.findViewById(R.id.tipo_birra);
            RankingPorcentaje = itemView.findViewById(R.id.porcentaje_birra);
            staticFelicidad = itemView.findViewById(R.id.felicidad);
        }
    }

    private List<Cervecerias> mCervecerias;


    public CerveceriasAdapter(List<Cervecerias> cervecerias) {
        mCervecerias = cervecerias;
    }
}
