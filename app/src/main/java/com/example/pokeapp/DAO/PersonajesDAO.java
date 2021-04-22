package com.example.pokeapp.DAO;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.pokeapp.Models.Pokemon;
import com.example.pokeapp.Resources.Constants;

import java.util.ArrayList;
import java.util.List;



public class PersonajesDAO {


    public static PersonajesDAO personajesDAO;

    private PersonajesDAO() {
    }

    public static PersonajesDAO getInstance(){
        if (personajesDAO == null){
            personajesDAO = new PersonajesDAO();
        }
        return  personajesDAO;
    }


    //METODO QUE OBTIENE LA LISTA DE LOS POKEMONES
    public void getPokemones(Context context, int value, final DAO.OnResultadoListaConsulta<Pokemon>listener){
        String url = Constants.SERVER+Constants.RUTA+"ability/?limit="+value+"&offset="+value;

        Peticion.GET get = new Peticion.GET(context,url);
            get.getResponse(new Peticion.OnPeticionListener<String>() {
                @Override
                public void onSuccess(String s) {
                    JSONObject jsonObject;
                    JSONArray jsonresults;
                    JSONObject jsonPokemon;
                    List<Pokemon> listPokemones;

                    try {
                        jsonObject = new JSONObject(s);
                        jsonresults = jsonObject.getJSONArray("results");

                        if(jsonresults.length() > 0){
                            listPokemones = new ArrayList<>();
                            for(int i = 0; i< jsonresults.length(); i++){
                                jsonPokemon = jsonresults.getJSONObject(i);
                                Pokemon pokemon = new Pokemon(jsonPokemon.getString("name"),jsonPokemon.getString("url"));
                                listPokemones.add(pokemon);
                            }
                            listener.consultaSuccess(listPokemones);
                        }else{
                            listener.consultaSuccess(null);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.consultaSuccess(null);
                    }
                }

                @Override
                public void onFailed(String s, int i) {
                    listener.consultaFailed(s, i);

                }
            });
    }

    //METODO QUE OBTIENE LA LISTA DE LOS POKEMONES
    public void getdescription(Context context, String url, final DAO.OnResultadoListaConsulta<Pokemon>listener){
        Peticion.GET get = new Peticion.GET(context,url);
            get.getResponse(new Peticion.OnPeticionListener<String>() {
                @Override
                public void onSuccess(String s) {
                    JSONObject jsonObject;
                    JSONArray jsonresults;
                    JSONObject jsonPokemon;
                    List<Pokemon> listPokemones;

                    try {
                        jsonObject = new JSONObject(s);
                        jsonresults = jsonObject.getJSONArray("results");

                        if(jsonresults.length() > 0){
                            listPokemones = new ArrayList<>();
                            for(int i = 0; i< jsonresults.length(); i++){
                                jsonPokemon = jsonresults.getJSONObject(i);
                                Pokemon pokemon = new Pokemon(jsonPokemon.getString("name"),jsonPokemon.getString("url"));
                                listPokemones.add(pokemon);
                            }
                            listener.consultaSuccess(listPokemones);
                        }else{
                            listener.consultaSuccess(null);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.consultaSuccess(null);
                    }
                }

                @Override
                public void onFailed(String s, int i) {
                    listener.consultaFailed(s, i);

                }
            });
    }



}
