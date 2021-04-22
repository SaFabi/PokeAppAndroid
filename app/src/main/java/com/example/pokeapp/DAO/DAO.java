package com.example.pokeapp.DAO;


import java.util.List;

/**
 * Created by Fabi on 14/08/2018.
 */

public abstract class DAO  {
    //PARA OBTENER INFORMACION DE LA BASE DE DATOS
    public interface OnResultadoConsulta<T>{
        void consultaSuccess(T t);

        void consultaFailed(String error, int codigo);

    }

    //PARA GENERAR LISTA CON LOS DATOS DE LA BASE DE DATOS
    public interface OnResultadoListaConsulta<T>{
        void consultaSuccess(List<T> t);

        void consultaFailed (String error, int codigo);
    }


}
