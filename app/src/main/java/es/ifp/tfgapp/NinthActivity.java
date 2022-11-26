package es.ifp.tfgapp;

import androidx.appcompat.app.AlertDialog;
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

public class NinthActivity extends AppCompatActivity {

    protected TextView labelTituloCaja;
    protected ListView listaCajas;
    protected Button botonVolverCajas;

    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> cajas = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorCajas;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String [] partes;
    protected String identificadorCaja;

    protected ArrayList<String> infoCaja;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);

        labelTituloCaja = findViewById(R.id.label1_ninth);
        listaCajas = findViewById(R.id.listview1_ninth);
        botonVolverCajas = findViewById(R.id.boton1_ninth);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfCajas() == 0) {
            BaseDatosComponentes.insertarCajas();
        }

        switch (General.rangoElegido) {
            case 1:
                cajas = BaseDatosComponentes.getCajasRango(1);
                adaptadorCajas = new ArrayAdapter<>(NinthActivity.this, android.R.layout.simple_list_item_1, cajas);
                listaCajas.setAdapter(adaptadorCajas);
                break;
            case 2:
                cajas = BaseDatosComponentes.getCajasRango(2);
                adaptadorCajas = new ArrayAdapter<>(NinthActivity.this, android.R.layout.simple_list_item_1, cajas);
                listaCajas.setAdapter(adaptadorCajas);
                break;
            case 3:
                cajas = BaseDatosComponentes.getCajasRango(3);
                adaptadorCajas = new ArrayAdapter<>(NinthActivity.this, android.R.layout.simple_list_item_1, cajas);
                listaCajas.setAdapter(adaptadorCajas);
                break;
            default:
                break;
        }
        listaCajas.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorCaja = partes[0];
                General.idCaja = Integer.parseInt(identificadorCaja);
                pasarPantalla = new Intent(NinthActivity.this, TenthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaCajas.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorCaja = partes[0];
            }
            infoCaja = BaseDatosComponentes.getCajasInfo(Integer.parseInt(identificadorCaja));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(NinthActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverCajas.setOnClickListener(view -> {
            pasarPantalla = new Intent(NinthActivity.this, EighthActivity.class);
            finish();
            startActivity(pasarPantalla);
        });

    }

    public void convertirAString() {
        for (String s : infoCaja) {
            stringbuffer.append(s);
        }
        stringInfo = stringbuffer.toString();
    }
}