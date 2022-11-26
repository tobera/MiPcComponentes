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

public class SixthActivity extends AppCompatActivity {

    protected TextView labelTituloRam;
    protected TextView labelRecomendacionRam;
    protected ListView listaMemoriasRam;
    protected Button botonVolverMemoriasRAM;

    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> memoriasRAM = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorMemoriasRAM;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String [] partes;
    protected String identificadorMemoriasRAM;

    protected ArrayList<String> infoMemoriasRAM;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;

    protected ArrayList<String> marcaProcesador = new ArrayList<>();
    private final StringBuffer stringbuffer2= new StringBuffer();
    private String stringMarcaProcesador;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        labelTituloRam = findViewById(R.id.label1_sixth);
        labelRecomendacionRam = findViewById(R.id.label2_sixth);
        listaMemoriasRam = findViewById(R.id.listview1_sixth);
        botonVolverMemoriasRAM = findViewById(R.id.boton1_sixth);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfMemoriasRam() == 0) {
            BaseDatosComponentes.insertarMemoriasRam();
        }

        marcaProcesador = BaseDatosComponentes.getProcesadorMarca(General.idProcesador);
        convertirAString2();
        if (stringMarcaProcesador.equals("AMD")){
            labelRecomendacionRam.setText(getResources().getString(R.string.el_fabricante_seleccionado_es)+" "+ stringMarcaProcesador + getResources().getString(R.string.recomendacion_RAM_AMD));
        } else if (stringMarcaProcesador.equals("INTEL")){
            labelRecomendacionRam.setText(getResources().getString(R.string.el_fabricante_seleccionado_es)+" "+ stringMarcaProcesador  + getResources().getString(R.string.recomendacion_RAM_INTEL));
        }


        switch (General.rangoElegido) {
            case 1:
                memoriasRAM = BaseDatosComponentes.getMemoriasramRango(1);
                adaptadorMemoriasRAM = new ArrayAdapter<>(SixthActivity.this, android.R.layout.simple_list_item_1, memoriasRAM);
                listaMemoriasRam.setAdapter(adaptadorMemoriasRAM);
                break;
            case 2:
                memoriasRAM = BaseDatosComponentes.getMemoriasramRango(2);
                adaptadorMemoriasRAM = new ArrayAdapter<>(SixthActivity.this, android.R.layout.simple_list_item_1, memoriasRAM);
                listaMemoriasRam.setAdapter(adaptadorMemoriasRAM);
                break;
            case 3:
                memoriasRAM = BaseDatosComponentes.getMemoriasramRango(3);
                adaptadorMemoriasRAM = new ArrayAdapter<>(SixthActivity.this, android.R.layout.simple_list_item_1, memoriasRAM);
                listaMemoriasRam.setAdapter(adaptadorMemoriasRAM);
                break;
            default:
                break;
        }
        listaMemoriasRam.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorMemoriasRAM = partes[0];
                General.idMemoriasRAM = Integer.parseInt(identificadorMemoriasRAM);
                pasarPantalla = new Intent(SixthActivity.this, SeventhActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaMemoriasRam.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorMemoriasRAM = partes[0];
            }
            infoMemoriasRAM = BaseDatosComponentes.getMemoriasramInfo(Integer.parseInt(identificadorMemoriasRAM));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(SixthActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverMemoriasRAM.setOnClickListener(view -> {
            pasarPantalla = new Intent(SixthActivity.this, FifthActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }




    public void convertirAString() {
        for (String s : infoMemoriasRAM) {
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