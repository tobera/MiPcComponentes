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

public class EighthActivity extends AppCompatActivity {

    protected TextView labelTituloRefrigeracion;
    protected TextView labelTipo;
    protected ListView listaRefrigeraciones;
    protected Button botonAire;
    protected Button botonLiquida;
    protected Button botonVolverRefrigeracion;

    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> refrigeraciones = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorRefrigeraciones;

    protected String tipo;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String [] partes;
    protected String identificadorRefrigeracion;

    protected ArrayList<String> infoRefrigeracion;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);

        labelTituloRefrigeracion = findViewById(R.id.label1_eighth);
        labelTipo = findViewById(R.id.label2_eighth);
        listaRefrigeraciones = findViewById(R.id.listview1_eighth);
        botonAire = findViewById(R.id.boton1_eighth);
        botonLiquida = findViewById(R.id.boton2_eighth);
        botonVolverRefrigeracion = findViewById(R.id.boton3_eighth);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfRefrigeraciones() == 0) {
            BaseDatosComponentes.insertarRefrigeraciones();
        }

        botonAire.setOnClickListener(view -> {
            tipo = "AIRE";
            switch (General.rangoElegido) {
                case 1:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(1, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                case 2:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(2, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                case 3:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(3, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                default:
                    break;
            }
        });
        botonLiquida.setOnClickListener(view -> {
            tipo = "LIQUIDA";
            switch (General.rangoElegido) {
                case 1:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(1, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                case 2:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(2, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                case 3:
                    refrigeraciones = BaseDatosComponentes.getRefrigeracionesRango(3, tipo);
                    adaptadorRefrigeraciones = new ArrayAdapter<>(EighthActivity.this, android.R.layout.simple_list_item_1, refrigeraciones);
                    listaRefrigeraciones.setAdapter(adaptadorRefrigeraciones);
                    break;
                default:
                    break;
            }
        });
        listaRefrigeraciones.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorRefrigeracion = partes[0];
                General.idRefrigeracion= Integer.parseInt(identificadorRefrigeracion);
                pasarPantalla = new Intent(EighthActivity.this, NinthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaRefrigeraciones.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorRefrigeracion = partes[0];
            }
            infoRefrigeracion = BaseDatosComponentes.getRefrigeracionesInfo(Integer.parseInt(identificadorRefrigeracion));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(EighthActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverRefrigeracion.setOnClickListener(view -> {
            pasarPantalla = new Intent(EighthActivity.this, SeventhActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }
    public void convertirAString() {
        for (String s : infoRefrigeracion) {
            stringbuffer.append(s);
        }
        stringInfo = stringbuffer.toString();
    }
}