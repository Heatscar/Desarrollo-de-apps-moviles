package com.example.evaluacionparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (EditText) findViewById(R.id.inputValue);


        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        text.setText(pref.getString("numero", ""));
    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClickBtn(View view) {
        SharedPreferences pref = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("numero",text.getText().toString());

        edit.commit();
        switch (view.getId()) {
            //case R.id.button:
            case R.id.imageButton2:

                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Ingrese un numero valido",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String
                            .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;

        }
    }
}