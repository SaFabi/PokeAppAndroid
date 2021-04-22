package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokeapp.Resources.SharedPreferencesLogin;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtuser, edtpass;
    private SharedPreferencesLogin preferenciasLogin = new SharedPreferencesLogin(MainActivity.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        edtuser = findViewById(R.id.txtNick);
        edtpass = findViewById(R.id.txtxPass);

        if(preferenciasLogin.getSesion() != null && preferenciasLogin.getSesion().equals("true")) {

            Intent intent = new Intent(MainActivity.this, listaPokemones.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser.getText().length()> 0 && edtpass.getText().length() > 0){
                    preferenciasLogin.setValues(edtuser.getText().toString(),edtpass.getText().toString(),"true");

                    Intent intent = new Intent(MainActivity.this, listaPokemones.class);
                    startActivity(intent);
                    finish();

                }else{
                    edtuser.setError("Ingrese un correo valido");
                }

            }
        });
    }
}