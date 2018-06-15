package com.example.joseflores.ciudades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joseflores.ciudades.entidades.PersonajeVo;
import com.example.joseflores.ciudades.fragmentos.DetallePersonaje;
import com.example.joseflores.ciudades.fragmentos.ListaPersonajes;
import com.example.joseflores.ciudades.interfaces.IComunicaFragments;
import com.example.joseflores.ciudades.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity implements IComunicaFragments{

    ListaPersonajes listaFragment;
    DetallePersonaje detalleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragmentContenedor) != null){

            Utilidades.portatrait = true;

            if (savedInstanceState != null) return;

            listaFragment = new ListaPersonajes();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContenedor, listaFragment).commit();
        }else
            Utilidades.portatrait = false;


    }

    @Override
    public void enviarPersonaje(PersonajeVo personajeVo) {

        detalleFragment = (DetallePersonaje) this.getSupportFragmentManager().findFragmentById(R.id.fragDetalle);

        if (detalleFragment != null && findViewById(R.id.fragmentContenedor) == null){

            detalleFragment.asignarInformacion(personajeVo);

        }else {

            detalleFragment = new DetallePersonaje();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto", personajeVo);
            detalleFragment.setArguments(bundleEnvio);

            //Cargar el fragment en el activity

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContenedor, detalleFragment).addToBackStack(null).commit();

        }

    }
}
