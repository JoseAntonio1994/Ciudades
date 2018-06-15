package com.example.joseflores.ciudades.fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.joseflores.ciudades.R;
import com.example.joseflores.ciudades.adaptadores.AdaptadorPersonajes;
import com.example.joseflores.ciudades.entidades.PersonajeVo;
import com.example.joseflores.ciudades.interfaces.IComunicaFragments;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaPersonajes extends Fragment {

    private ArrayList<PersonajeVo> listaPersonajes;
    private RecyclerView recyclerPersonajes;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;


    public ListaPersonajes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonajes = new ArrayList<PersonajeVo>();

        recyclerPersonajes = (RecyclerView) view.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPersonajes();

        AdaptadorPersonajes adaptador = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Selecciona: " + listaPersonajes.get(recyclerPersonajes
                        .getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarPersonaje(listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)));

            }
        });

        return view;
    }

    private void llenarListaPersonajes() {

        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chiapas), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.chiapas, R.drawable.chiapas));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chihuahua), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.chihuahua, R.drawable.chihuahua));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chiapas), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.palenque, R.drawable.palenque));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_veracruz), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.tajin, R.drawable.tajin));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_guerrero), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.taxco, R.drawable.taxco));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chiapas), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.chiapas, R.drawable.chiapas));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chihuahua), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.chihuahua, R.drawable.chihuahua));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_chiapas), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.palenque, R.drawable.palenque));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_veracruz), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.tajin, R.drawable.tajin));
        listaPersonajes.add(new PersonajeVo(getString(R.string.nom_guerrero), getString(R.string.informacion),
                getString(R.string.detalle), R.drawable.taxco, R.drawable.taxco));


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){

            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;

        }
    }
}
