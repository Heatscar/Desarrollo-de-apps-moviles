package com.example.sharedpreferencessearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextCarrera;
    EditText editTextControl;
    EditText busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Activity2");

        ImageButton buttonBack = findViewById(R.id.imageButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityIntent);
            }
        });

        editTextNombre=findViewById(R.id.txbNombre);
        editTextCarrera=findViewById(R.id.txbCarrera);
        editTextControl=findViewById(R.id.txbNumero);
        busqueda=findViewById(R.id.txbBusqueda);
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editTextNombre.setText(pref.getString(editTextCarrera.getText().toString()+"nombre", ""));
        editTextCarrera.setText(pref.getString(editTextCarrera.getText().toString()+"carrera", ""));
        editTextControl.setText(pref.getString(editTextCarrera.getText().toString()+"control", ""));
    }

    public void Guardar(View v){
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(editTextControl.getText().toString()+"nombre",editTextNombre.getText().toString());
        edit.putString(editTextControl.getText().toString()+"carrera",editTextCarrera.getText().toString());
        edit.putString(editTextControl.getText().toString()+"control",editTextControl.getText().toString());
        edit.commit();
    }

    public void Buscar(View v){
        SharedPreferences settings =this.getSharedPreferences("datos", Context.MODE_PRIVATE);
        String userData = settings.getString(editTextControl.getText().toString()+"control", settings.getString("control", ""));

        String valor = busqueda.getText().toString();

        int valorbusqueda = Integer.parseInt(valor);

        if(valorbusqueda != 0){
            //password has not been saved...
            Toast.makeText(getApplicationContext(),"Registro encontrado",Toast.LENGTH_LONG).show();
            SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            editTextNombre.setText(pref.getString(valorbusqueda+"nombre", ""));
            editTextCarrera.setText(pref.getString(valorbusqueda+"carrera", ""));
            editTextControl.setText(pref.getString(valorbusqueda+"control", ""));
        }
        else {
            Toast.makeText(getApplicationContext(), "No hay registros", Toast.LENGTH_LONG).show();
            //password has not been saved...

        }
    }
}