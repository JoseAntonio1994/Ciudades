package com.example.joseflores.ciudades.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseflores.ciudades.R;
import com.example.joseflores.ciudades.entidades.PersonajeVo;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetallePersonaje extends Fragment {

    private TextView textDescripcion;
    private ImageView imagenDescripcion;


    public DetallePersonaje() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false);

        textDescripcion = (TextView) view.findViewById(R.id.descripcionId);
        imagenDescripcion = (ImageView) view.findViewById(R.id.imagenDetalleId);

        Bundle objetoPersonaje = getArguments();
        PersonajeVo personajeVo = null;

        if (objetoPersonaje != null){

            personajeVo = (PersonajeVo) objetoPersonaje.getSerializable("objeto");
            asignarInformacion(personajeVo);


        }

        return view;
    }

    public void asignarInformacion(PersonajeVo personajeVo) {

        imagenDescripcion.setImageResource(personajeVo.getImagenDetalle());
        textDescripcion.setText(personajeVo.getDescripcion());

    }

}
