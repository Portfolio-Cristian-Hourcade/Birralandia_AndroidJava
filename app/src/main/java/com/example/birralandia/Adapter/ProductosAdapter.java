package com.example.birralandia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.birralandia.Model.Cervecerias;
import com.example.birralandia.Model.ProductosList;
import com.example.birralandia.R;

import org.w3c.dom.Text;

import java.util.List;

public class ProductosAdapter extends
        RecyclerView.Adapter<ProductosAdapter.ViewHolder> {


    @Override
    public ProductosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.product_item_labirrabar, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ProductosAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ProductosList _Cervecerias = mCervecerias.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.Title;
        textView.setText(_Cervecerias.getTitulo());

        ImageView _Background = viewHolder.Background;
        _Background.setImageResource(_Cervecerias.getmBackground());

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
        public ImageView Background;
        public ImageView Logo;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.Title);
            Background = (ImageView) itemView.findViewById(R.id.background_bb);

        }
    }

    private List<ProductosList> mCervecerias;


    public ProductosAdapter(List<ProductosList> contacts) {
        mCervecerias = contacts;
    }
}
