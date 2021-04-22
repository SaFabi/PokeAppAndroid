package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pokeapp.Adapters.PokemonAdapter;
import com.example.pokeapp.DAO.DAO;
import com.example.pokeapp.DAO.PersonajesDAO;
import com.example.pokeapp.Models.Pokemon;

import java.util.List;

public class listaPokemones extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private ProgressDialog progressDialog;
    PersonajesDAO personajesDAO = PersonajesDAO.getInstance();
    PokemonAdapter pokemonAdapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemones);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando");
        progressDialog.setMessage("Espere un momento...");
        progressDialog.setCanceledOnTouchOutside(false);

        recyclerView = findViewById(R.id.rcvPokemon);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this);

        getLista();

    }


    public void getLista(){

        progressDialog.show();

        personajesDAO.getPokemones(getApplicationContext(), 20, new DAO.OnResultadoListaConsulta<Pokemon>() {
            @Override
            public void consultaSuccess(List<Pokemon> t) {
                progressDialog.dismiss();
                if (t != null){
                    if (t.size()>0){
                        PokemonAdapter pokemonAdapter = new PokemonAdapter(t);
                        recyclerView.setAdapter(pokemonAdapter);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
                    }else{
                        recyclerView.setAdapter(null);
                    }
                }else{
                    recyclerView.setAdapter(null);
                }
            }
            @Override
            public void consultaFailed(String error, int codigo) {
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}