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

public class SeventhActivity extends AppCompatActivity {

    protected TextView labelTituloPSU;
    protected ListView listaPSU;
    protected Button botonVolverPSU;


    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> fuentesAlimentacion = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorFuentesAlimentacion;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String [] partes;
    protected String identificadorFuentesAlimentacion;

    protected ArrayList<String> infoFuentesAlimentacion;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        labelTituloPSU = findViewById(R.id.label1_seventh);
        listaPSU = findViewById(R.id.listview1_seventh);
        botonVolverPSU = findViewById(R.id.boton1_seventh);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfFuentesAlimentacion() == 0) {
            BaseDatosComponentes.insertarFuentesAlimentacion();
        }

        switch (General.rangoElegido) {
            case 1:
                fuentesAlimentacion = BaseDatosComponentes.getFuentesalimentacionRango(1);
                adaptadorFuentesAlimentacion = new ArrayAdapter<>(SeventhActivity.this, android.R.layout.simple_list_item_1, fuentesAlimentacion);
                listaPSU.setAdapter(adaptadorFuentesAlimentacion);
                break;
            case 2:
                fuentesAlimentacion = BaseDatosComponentes.getFuentesalimentacionRango(2);
                adaptadorFuentesAlimentacion = new ArrayAdapter<>(SeventhActivity.this, android.R.layout.simple_list_item_1, fuentesAlimentacion);
                listaPSU.setAdapter(adaptadorFuentesAlimentacion);
                break;
            case 3:
                fuentesAlimentacion = BaseDatosComponentes.getFuentesalimentacionRango(3);
                adaptadorFuentesAlimentacion = new ArrayAdapter<>(SeventhActivity.this, android.R.layout.simple_list_item_1, fuentesAlimentacion);
                listaPSU.setAdapter(adaptadorFuentesAlimentacion);
                break;
            default:
                break;
        }
        listaPSU.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorFuentesAlimentacion = partes[0];
                General.idPSU = Integer.parseInt(identificadorFuentesAlimentacion);
                pasarPantalla = new Intent(SeventhActivity.this, EighthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaPSU.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorFuentesAlimentacion = partes[0];
            }
            infoFuentesAlimentacion = BaseDatosComponentes.getFuentesalimentacionInfo(Integer.parseInt(identificadorFuentesAlimentacion));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(SeventhActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverPSU.setOnClickListener(view -> {
            pasarPantalla = new Intent(SeventhActivity.this, SixthActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }
    public void convertirAString() {
        for (String s : infoFuentesAlimentacion) {
            stringbuffer.append(s);
        }
        stringInfo = stringbuffer.toString();
    }
}