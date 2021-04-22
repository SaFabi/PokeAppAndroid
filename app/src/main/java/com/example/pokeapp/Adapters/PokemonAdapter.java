package com.example.pokeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapp.Models.Pokemon;
import com.example.pokeapp.R;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {
    List<Pokemon> lista;

    public PokemonAdapter(List<Pokemon> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lista, parent, false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonHolder holder, int position) {
        holder.txtNombre.setText(lista.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class PokemonHolder extends RecyclerView.ViewHolder
    {
        TextView txtNombre;
        public PokemonHolder(View itemView)
        {
            super(itemView);
            txtNombre = (TextView)itemView.findViewById(R.id.txtNombre);

        }
    }
}


