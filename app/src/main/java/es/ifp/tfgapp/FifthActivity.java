package es.ifp.tfgapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import es.ifp.tfgapp.basedatos.BaseDatosSQLite;
import es.ifp.tfgapp.componentes.General;

public class FifthActivity extends AppCompatActivity {

    protected TextView labelTituloGraficas;
    protected TextView labelRecomendacion;
    protected TextView labelFabricante;
    protected TextView labelInfo;
    protected ListView listaGraficas;
    protected Button botonNVIDIA;
    protected Button botonAMD;
    protected Button botonVolverGraficas;

    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> tarjetasGraficas = new ArrayList<>();
    protected ArrayAdapter<String> adaptadortarjetasGraficas;

    protected String fabricante;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String [] partes;
    protected String identificadorTarjetaGrafica;

    protected ArrayList<String> infoTarjetaGrafica;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;

    protected ArrayList<String> marcaProcesador = new ArrayList<>();
    private final StringBuffer stringbuffer2 = new StringBuffer();
    private String stringMarcaProcesador;
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        labelTituloGraficas = findViewById(R.id.label1_fifth);
        labelRecomendacion =  findViewById(R.id.label2_fifth);
        labelFabricante =  findViewById(R.id.label3_fifth);
        labelInfo =  findViewById(R.id.label4_fifth);
        listaGraficas = findViewById(R.id.listview1_fifth);
        botonNVIDIA =  findViewById(R.id.boton1_fifth);
        botonAMD = findViewById(R.id.boton2_fifth);
        botonVolverGraficas = findViewById(R.id.boton3_fifth);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfTarjetasGraficas() == 0) {
            BaseDatosComponentes.insertarTarjetasGraficas();
        }

        marcaProcesador = BaseDatosComponentes.getProcesadorMarca(General.idProcesador);
        convertirAString2();
        if (stringMarcaProcesador.equals("AMD")){
            labelRecomendacion.setText(getResources().getString(R.string.el_fabricante_seleccionado_es)+" "+ stringMarcaProcesador + getResources().getString(R.string.recomendacion_fabricante_AMD));
            stringbuffer2.delete(0,stringbuffer2.length());
        } else if (stringMarcaProcesador.equals("INTEL")){
            labelRecomendacion.setText(getResources().getString(R.string.el_fabricante_seleccionado_es)+" "+ stringMarcaProcesador + getResources().getString(R.string.recomendacion_fabricante_NVIDIA));
        }


        botonNVIDIA.setOnClickListener(view -> {
            fabricante = "NVIDIA";
            switch (General.rangoElegido) {
                case 1:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(1, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                case 2:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(2, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                case 3:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(3, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                default:
                    break;
            }
        });
        botonAMD.setOnClickListener(view -> {
            fabricante = "AMD";
            switch (General.rangoElegido) {
                case 1:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(1, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                case 2:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(2, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                case 3:
                    tarjetasGraficas = BaseDatosComponentes.getTarjetasGraficasRango(3, fabricante);
                    adaptadortarjetasGraficas = new ArrayAdapter<>(FifthActivity.this, android.R.layout.simple_list_item_1, tarjetasGraficas);
                    listaGraficas.setAdapter(adaptadortarjetasGraficas);
                    break;
                default:
                    break;
            }
        });
        listaGraficas.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorTarjetaGrafica = partes[0];
                General.idTarjetaGrafica = Integer.parseInt(identificadorTarjetaGrafica);
                pasarPantalla = new Intent(FifthActivity.this, SixthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaGraficas.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorTarjetaGrafica = partes[0];
            }
            infoTarjetaGrafica = BaseDatosComponentes.getTarjetasGraficasInfo(Integer.parseInt(identificadorTarjetaGrafica));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(FifthActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverGraficas.setOnClickListener(view -> {
            pasarPantalla = new Intent(FifthActivity.this, FourthActivity.class);
            finish();
            startActivity(pasarPantalla);
        });


    }

    public void convertirAString() {
        for (String s : infoTarjetaGrafica) {
            stringbuffer.append(s);
        }
        stringInfo = stringbuffer.toString();
    }
    public void convertirAString2() {
        for (String s : marcaProcesador) {
            stringbuffer2.append(s);
        }
        stringMarcaProcesador = stringbuffer2.toString();
    }
    }