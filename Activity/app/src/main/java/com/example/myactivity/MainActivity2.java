package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;

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

        editText=findViewById(R.id.edtTxtNombre);
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editText.setText(pref.getString("nombre", ""));
    }

    public void Guardar(View v){
        SharedPreferences pref = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("nombre",editText.getText().toString());
        edit.commit();
    }
}