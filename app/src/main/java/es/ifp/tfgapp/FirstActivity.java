package es.ifp.tfgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import es.ifp.tfgapp.componentes.General;

public class FirstActivity extends AppCompatActivity {

    protected TextView labelTitulo;
    protected TextView labelSubtitulo;
    protected TextView labelTexto;
    protected TextView labelInformacion;
    protected Button botonRango1;
    protected Button botonRango2;
    protected Button botonRango3;

    public int rango;
    public String rango_String="";
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        labelTitulo = findViewById(R.id.label1_start);
        labelSubtitulo = findViewById(R.id.label2_start);
        botonRango1 = findViewById(R.id.boton1_start);
        botonRango2 =  findViewById(R.id.boton2_start);
        botonRango3 =  findViewById(R.id.boton3_start);
        labelTexto =  findViewById(R.id.label3_start);
        labelInformacion =  findViewById(R.id.label4_start);


        botonRango1.setOnLongClickListener(view -> {
            labelInformacion.setVisibility(View.VISIBLE);
            labelInformacion.setText(R.string.masinfo1);
            return true;
        });

        botonRango1.setOnClickListener(view -> {
            rango = 1;
            General.rangoElegido = rango;
            rango_String= Integer.toString(rango);
            pasarPantalla = new Intent(FirstActivity.this, SecondActivity.class);
            finish();
            startActivity(pasarPantalla);
        });


        botonRango2.setOnLongClickListener(view -> {
            labelInformacion.setVisibility(View.VISIBLE);
            labelInformacion.setText(R.string.masinfo2);
            return true;
        });
        botonRango2.setOnClickListener(view -> {
            rango = 2;
            General.rangoElegido = rango;
            rango_String= Integer.toString(rango);
            pasarPantalla = new Intent(FirstActivity.this, SecondActivity.class);
            finish();
            startActivity(pasarPantalla);
        });

        botonRango3.setOnLongClickListener(view -> {
            labelInformacion.setVisibility(View.VISIBLE);
            labelInformacion.setText(R.string.masinfo3);
            return true;
        });
        botonRango3.setOnClickListener(view -> {
            rango = 3;
            General.rangoElegido = rango;
            rango_String= Integer.toString(rango);
            pasarPantalla = new Intent(FirstActivity.this, SecondActivity.class);
            finish();
            startActivity(pasarPantalla);
        });

    }

}