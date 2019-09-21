package com.example.lavaderocolores.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.lavaderocolores.Adapter.CerveceriasAdapter;
import com.example.lavaderocolores.LaBirraBar.LaBirraBarActivity;
import com.example.lavaderocolores.Model.Cervecerias;
import com.example.lavaderocolores.Model.RecyclerItemClickListener;
import com.example.lavaderocolores.R;

import java.util.ArrayList;

public class ListCervezasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_list_cervezas, container, false);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Cervecerias> list = new ArrayList<Cervecerias>();

        RecyclerView recyclerView = view.findViewById(R.id.cervezas_list);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView aux = view.findViewById(R.id.title_birra);

                        /** Cargar la nueva activity de la cerveceria **/
                        switch (aux.getText() + "") {
                            case "La Birra Bar":
                                startActivity(new Intent(getContext(), LaBirraBarActivity.class));
                                getActivity().overridePendingTransition(R.anim.go_entrada, R.anim.go_salida);

                                break;
                            case "Antares ":
                                break;
                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        list.add(new Cervecerias("La Birra Bar", "Av. Carlos Calvo 4266, Caba.", R.drawable.birra_landia_logo, "90%", "Local BIRPREMIUM"));


        list.add(new Cervecerias("Antares", "Av. Carlos Calvo 4266, Caba.", R.drawable.oferta_2, "54%", "Local BIRPREMIUM"));
        list.add(new Cervecerias("Cervelar", "Av. Carlos Calvo 4266, Caba.", R.drawable.oferta_1, "78%", "Local BIRPLAT"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CerveceriasAdapter(list));

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.salida_750ms);
        recyclerView.startAnimation(animation);
    }
}
