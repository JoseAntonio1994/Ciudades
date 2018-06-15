package com.example.joseflores.ciudades.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseflores.ciudades.R;
import com.example.joseflores.ciudades.entidades.PersonajeVo;
import com.example.joseflores.ciudades.utilidades.Utilidades;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.PersonajesViewHolder> implements View.OnClickListener{

    private ArrayList<PersonajeVo> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public PersonajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        view.setOnClickListener(this);

        return new PersonajesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajesViewHolder holder, int position) {

        holder.txtNombre.setText(listaPersonajes.get(position).getNombre());

        if (Utilidades.portatrait){
            holder.txtInformacion.setText(listaPersonajes.get(position).getInfo());
        }

        holder.foto.setImageResource(listaPersonajes.get(position).getImagenId());

    }

    @Override
    public int getItemCount() {
        return this.listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

        if (listener != null){

            listener.onClick(v);

        }

    }

    public class PersonajesViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre, txtInformacion;
        ImageView foto;

        public PersonajesViewHolder(View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.idImagen);
            txtNombre = (TextView) itemView.findViewById(R.id.idNombre);

            if (Utilidades.portatrait)
                txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
        }
    }
}
