package es.ifp.tfgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import es.ifp.tfgapp.basedatos.BaseDatosSQLite;
import es.ifp.tfgapp.componentes.General;

public class TenthActivity extends AppCompatActivity {

    protected TextView labelTituloFinal;
    protected TextView labelProcesador;
    protected TextView labelPlacaBase;
    protected TextView labelDiscoDuro;
    protected TextView labelTarjetaGrafica;
    protected TextView labelMemoriaRam;
    protected TextView labelFuenteAlimentacion;
    protected TextView labelRefrigeracion;
    protected TextView labelCaja;
    protected ListView procesador;
    protected ListView placaBase;
    protected ListView discoDuro;
    protected ListView tarjetaGrafica;
    protected ListView memoriaRam;
    protected ListView fuenteAlimentacion;
    protected ListView refrigeracion;
    protected ListView caja;
    protected Button botonVolver;
    protected Button botonVolverInicio;

    protected BaseDatosSQLite BaseDatosComponentes;

    //Listas
    protected ArrayList<String> procesadorLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorProcesadorLista;
    protected ArrayList<String> placaBaseLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorPlacaBaseLista;
    protected ArrayList<String> discoDuroLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorDiscoDuroLista;
    protected ArrayList<String> tarjetaGraficaLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorTarjetaGraficaLista;
    protected ArrayList<String> memoriaRamLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorMemoriaRamLista;
    protected ArrayList<String> fuenteAlimentacionLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorfuenteAlimentacionLista;
    protected ArrayList<String> refrigeracionLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorRefrigeracionLista ;
    protected ArrayList<String> cajaLista = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorCajaLista;


    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        labelTituloFinal = findViewById(R.id.label1_tenth);
        labelProcesador = findViewById(R.id.label2_tenth);
        labelPlacaBase = findViewById(R.id.label3_tenth);
        labelDiscoDuro = findViewById(R.id.label4_tenth);
        labelTarjetaGrafica = findViewById(R.id.label5_tenth);
        labelMemoriaRam = findViewById(R.id.label6_tenth);
        labelFuenteAlimentacion = findViewById(R.id.label7_tenth);
        labelRefrigeracion =  findViewById(R.id.label8_tenth);
        labelCaja = findViewById(R.id.label9_tenth);
        procesador = findViewById(R.id.listview1_tenth);
        placaBase =  findViewById(R.id.listview2_tenth);
        discoDuro = findViewById(R.id.listview3_tenth);
        tarjetaGrafica =  findViewById(R.id.listview4_tenth);
        memoriaRam =findViewById(R.id.listview5_tenth);
        fuenteAlimentacion =  findViewById(R.id.listview6_tenth);
        refrigeracion =  findViewById(R.id.listview7_tenth);
        caja = findViewById(R.id.listview8_tenth);
        botonVolver =  findViewById(R.id.boton1_tenth);
        botonVolverInicio =  findViewById(R.id.boton2_tenth);

        BaseDatosComponentes = new BaseDatosSQLite(this);

        insertarComponentes();
        mostrarComponentes();

        botonVolver.setOnClickListener(view -> {
            pasarPantalla = new Intent(TenthActivity.this, NinthActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
        botonVolverInicio.setOnClickListener(view -> {
            pasarPantalla = new Intent(TenthActivity.this, FirstActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }
    public void mostrarComponentes (){
        procesadorLista = BaseDatosComponentes.getProcesadorID(General.idProcesador);
        adaptadorProcesadorLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, procesadorLista);
        procesador.setAdapter(adaptadorProcesadorLista);

        placaBaseLista = BaseDatosComponentes.getPlacaBaseID(General.idPlacaBase);
        adaptadorPlacaBaseLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, placaBaseLista);
        placaBase.setAdapter(adaptadorPlacaBaseLista);

        discoDuroLista = BaseDatosComponentes.getDiscoDuroID(General.idDiscoDuro);
        adaptadorDiscoDuroLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, discoDuroLista);
        discoDuro.setAdapter(adaptadorDiscoDuroLista);

        tarjetaGraficaLista = BaseDatosComponentes.getTarjetaGraficaID(General.idTarjetaGrafica);
        adaptadorTarjetaGraficaLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, tarjetaGraficaLista);
        tarjetaGrafica.setAdapter(adaptadorTarjetaGraficaLista);

        memoriaRamLista = BaseDatosComponentes.getMemoriaRamID(General.idMemoriasRAM);
        adaptadorMemoriaRamLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, memoriaRamLista);
        memoriaRam.setAdapter(adaptadorMemoriaRamLista);

        fuenteAlimentacionLista = BaseDatosComponentes.getFuenteAlimentacionID(General.idPSU);
        adaptadorfuenteAlimentacionLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, fuenteAlimentacionLista);
        fuenteAlimentacion.setAdapter(adaptadorfuenteAlimentacionLista);

        refrigeracionLista = BaseDatosComponentes.getRefrigeracionID(General.idRefrigeracion);
        adaptadorRefrigeracionLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, refrigeracionLista);
        refrigeracion.setAdapter(adaptadorRefrigeracionLista);

        cajaLista = BaseDatosComponentes.getCajaID(General.idCaja);
        adaptadorCajaLista = new ArrayAdapter<>(TenthActivity.this, android.R.layout.simple_list_item_1, cajaLista);
        caja.setAdapter(adaptadorCajaLista);

    }
    public void insertarComponentes(){
        if (BaseDatosComponentes.numberOfProcesadores() == 0) {
            BaseDatosComponentes.insertarProcesadores();
        }
        if (BaseDatosComponentes.numberOfPlacasBase() == 0) {
            BaseDatosComponentes.insertarProcesadores();
        }
        if (BaseDatosComponentes.numberOfDiscosDuros() == 0) {
            BaseDatosComponentes.insertarDiscosDuros();
        }
        if (BaseDatosComponentes.numberOfTarjetasGraficas() == 0) {
            BaseDatosComponentes.insertarTarjetasGraficas();
        }
        if (BaseDatosComponentes.numberOfMemoriasRam() == 0) {
            BaseDatosComponentes.insertarMemoriasRam();
        }
        if (BaseDatosComponentes.numberOfRefrigeraciones() == 0) {
            BaseDatosComponentes.insertarRefrigeraciones();
        }
        if (BaseDatosComponentes.numberOfCajas() == 0) {
            BaseDatosComponentes.insertarCajas();
        }
        if (BaseDatosComponentes.numberOfFuentesAlimentacion() == 0) {
            BaseDatosComponentes.insertarFuentesAlimentacion();
        }
    }

}