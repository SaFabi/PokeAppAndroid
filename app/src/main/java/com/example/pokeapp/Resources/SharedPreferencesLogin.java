package com.example.pokeapp.Resources;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;



public class SharedPreferencesLogin {
    private Context context;
    private final String USER = "user";
    private final String PASS = "pass";
    private final String SESION = "false";

    public SharedPreferencesLogin(Context context)
    {
        this.context = context;
    }

    public static SharedPreferencesLogin getInstance(Context context)
    {
        return new SharedPreferencesLogin(context);
    }

    private SharedPreferences getSettings()
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    //Obtiene el usuario
    public String getUser()
    {
        return getSettings().getString(USER, null);
    }

    //Obtiene la contraseña
    public String getPass()
    {
        return getSettings().getString(PASS, null);
    }

    //Obtiene la sesion
    public String getSesion()
    {
        return getSettings().getString(SESION, null);
    }



    //Guarda el usuario y la contraseña
    public void setValues(String user, String pass,String sesion)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(USER, user);
        editor.putString(PASS, pass);
        editor.putString(SESION,sesion);
        editor.apply();
    }
}

