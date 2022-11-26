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

public class ThirdActivity extends AppCompatActivity {

    //Elementos de la UI
    protected TextView labelTituloPlacas;
    protected TextView labelFabricanteProcesadorPlacas;
    protected TextView labelOpcionesPlacas;
    protected Button botonVolverPlacas;
    protected ListView listaPlacas;

    //PARTE DE BASE DE DATOS
    protected BaseDatosSQLite BaseDatosComponentes;
    //PARTE DE BASE DE DATOS 2
    private ArrayList<String> infoPlacasBase = new ArrayList();
    private final StringBuffer sb = new StringBuffer();
    private String str;

    private String contenidoItem;
    private String[] partes;

    private ArrayList<String> infoMarca = new ArrayList<>();
    private final StringBuffer sb2 = new StringBuffer();
    private String str2;

    //PARTE DE GUARDADO DE INFO
    public String identificadorPlacaBase;
    //PARTE DE PASO DE PANTALLA
    private Intent pasarPantalla;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //PARTE REFERENCIA DE COMPONENTES
        labelTituloPlacas = findViewById(R.id.label1_third);
        labelFabricanteProcesadorPlacas =  findViewById(R.id.label2_third);
        labelOpcionesPlacas =  findViewById(R.id.label3_third);
        botonVolverPlacas =findViewById(R.id.boton1_third);
        listaPlacas =  findViewById(R.id.listview1_third);
        //PARTE BASE DE DATOS
        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfPlacasBase() == 0) {
            BaseDatosComponentes.insertarPlacasBase();
        }


        //PARTE DE CODIGO DE ACTIVTY

        //Parte Indicar FabricanteProcesador
        infoMarca = BaseDatosComponentes.getProcesadorMarca(General.idProcesador);
        convertirAString();
        labelFabricanteProcesadorPlacas.setText(getResources().getString(R.string.el_fabricante_seleccionado_es) +" "+str2);
        sb2.delete(0,sb2.length());


        //Parte contenido ListView
        ArrayList<String> placasBase = BaseDatosComponentes.getPlacasbaseRango(General.rangoElegido, str2);
        ArrayAdapter<String> adaptadorPlacasBase = new ArrayAdapter<>(ThirdActivity.this, android.R.layout.simple_list_item_1, placasBase);
        listaPlacas.setAdapter(adaptadorPlacasBase);

        //Parte interaccion ListView
        listaPlacas.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorPlacaBase = partes[0];
                General.idPlacaBase = Integer.parseInt(identificadorPlacaBase);
                pasarPantalla = new Intent(ThirdActivity.this, FourthActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaPlacas.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorPlacaBase = partes[0];
            }
            infoPlacasBase = BaseDatosComponentes.getPlacaBaseInfo(Integer.parseInt(identificadorPlacaBase));
            convertirAStringInfo();
            AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + str);
            AlertDialog informacion = builder.create();
            informacion.show();
            sb.delete(0, sb.length());
            return true;
        });

        botonVolverPlacas.setOnClickListener(view -> {
            pasarPantalla = new Intent(ThirdActivity.this, SecondActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }

    public void convertirAString() {
        for (String s : infoMarca) {
            sb2.append(s);
        }
        str2 = sb2.toString();
    }
    public void convertirAStringInfo(){
        for (String s : infoPlacasBase){
            sb.append(s);
            str = sb.toString();
        }
    }
}