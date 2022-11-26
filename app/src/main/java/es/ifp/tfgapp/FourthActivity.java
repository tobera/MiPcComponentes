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

public class FourthActivity extends AppCompatActivity {

    protected TextView labelTituloDiscos;
    protected TextView labelTipoDiscoDuro;
    protected ListView listaDiscos;
    protected Button botonHDD;
    protected Button botonSSD;
    protected Button botonVolverDiscos;
    protected BaseDatosSQLite BaseDatosComponentes;

    protected ArrayList<String> discosDuros = new ArrayList<>();
    protected ArrayAdapter<String> adaptadorDiscosDuros;

    protected String tipo;

    protected Intent pasarPantalla;

    protected String contenidoItem;
    protected String[] partes;
    protected String identificadorDiscoDuro;

    protected ArrayList<String> infoDiscosDuros;
    private final StringBuffer stringbuffer = new StringBuffer();
    private String stringInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        labelTituloDiscos = findViewById(R.id.label1_fourth);
        labelTipoDiscoDuro = findViewById(R.id.label2_fourth);
        listaDiscos = findViewById(R.id.listview1_fourth);
        botonHDD = findViewById(R.id.boton1_fourth);
        botonSSD =  findViewById(R.id.boton2_fourth);
        botonVolverDiscos =  findViewById(R.id.boton3_fourth);

        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfDiscosDuros() == 0) {
            BaseDatosComponentes.insertarDiscosDuros();
        }

        botonHDD.setOnClickListener(view -> {
            tipo = "HDD";
            switch (General.rangoElegido) {
                case 1:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(1, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                case 2:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(2, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                case 3:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(3, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                default:
                    break;
            }
        });
        botonSSD.setOnClickListener(view -> {
            tipo = "SSD";
            switch (General.rangoElegido) {
                case 1:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(1, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                case 2:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(2, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                case 3:
                    discosDuros = BaseDatosComponentes.getDiscosdurosRango(3, tipo);
                    adaptadorDiscosDuros = new ArrayAdapter<>(FourthActivity.this, android.R.layout.simple_list_item_1, discosDuros);
                    listaDiscos.setAdapter(adaptadorDiscosDuros);
                    break;
                default:
                    break;
            }
        });
        listaDiscos.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorDiscoDuro = partes[0];
                General.idDiscoDuro = Integer.parseInt(identificadorDiscoDuro);
                pasarPantalla = new Intent(FourthActivity.this, FifthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaDiscos.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorDiscoDuro = partes[0];
            }
            infoDiscosDuros = BaseDatosComponentes.getDiscosdurosInfo(Integer.parseInt(identificadorDiscoDuro));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + stringInfo);
            AlertDialog informacion = builder.create();
            informacion.show();
            stringbuffer.delete(0, stringbuffer.length());
            return true;
        });
        botonVolverDiscos.setOnClickListener(view -> {
            pasarPantalla = new Intent(FourthActivity.this, ThirdActivity.class);
            finish();
            startActivity(pasarPantalla);
        });


    }

    public void convertirAString() {
        for (String s : infoDiscosDuros) {
            stringbuffer.append(s);
        }
        stringInfo = stringbuffer.toString();
    }
}
