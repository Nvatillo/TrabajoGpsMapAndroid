package com.example.tareagps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText latitud;
    private EditText longitud;
    private EditText zoom;
    private CheckBox centrarMapa;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitud = findViewById(R.id.LatitudId);
        longitud = findViewById(R.id.LongitudId);
        zoom = findViewById(R.id.ZoomId);
        centrarMapa = findViewById(R.id.CentrarMapaId);
        error = findViewById(R.id.ErrorId);
    }

    public void siguientePantalla(View view){
        Intent intent = new Intent(this,Mapa.class);
        if (!latitud.getText().toString().equals("")){
            intent.putExtra("latitud", latitud.getText().toString());
        }else{
            error.setText("Latitud es Obligatorio");
            return;
        }
        if (!longitud.getText().toString().equals("")){
            intent.putExtra("longitud", longitud.getText().toString());
        }else{
            error.setText("Longitud es Obligatorio");
            return;
        }
        if (!zoom.getText().toString().equals("")){
            intent.putExtra("zoom", zoom.getText().toString());
        }else{
            intent.putExtra("zoom", "2.0");
        }
        if (centrarMapa.isChecked()){
            intent.putExtra("centrarMapa", "true");
        }else{
            intent.putExtra("centrarMapa", "false");
        }
        startActivity(intent);
    }

}