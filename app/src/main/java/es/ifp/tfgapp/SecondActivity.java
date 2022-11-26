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

public class SecondActivity extends AppCompatActivity {

    protected TextView labelTitulo;
    protected TextView labelFabricante;
    protected TextView labelOpciones;
    protected Button botonIntel;
    protected Button botonAMD;
    protected Button botonVolver;
    protected ListView listaProcesadores;


    protected BaseDatosSQLite BaseDatosComponentes;

    private ArrayList<String> procesadores = new ArrayList<>();
    private ArrayAdapter<String> adaptadorProcesadores;

    private ArrayList<String> infoProcesadores = new ArrayList();
    private final StringBuffer sb = new StringBuffer();
    private String str;

    private String contenidoItem;
    public String identificadorProcesador;
    private String[] partes;

    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        labelTitulo =  findViewById(R.id.label1_second);
        labelFabricante = findViewById(R.id.label2_second);
        labelOpciones =  findViewById(R.id.label3_second);
        botonIntel =  findViewById(R.id.boton1_second);
        botonAMD =  findViewById(R.id.boton2_second);
        botonVolver =  findViewById(R.id.boton3_second);
        listaProcesadores =  findViewById(R.id.listview1_second);


        // Crear la tabla de componentes solo si no existe una anterior ya creada.
        BaseDatosComponentes = new BaseDatosSQLite(this);
        if (BaseDatosComponentes.numberOfProcesadores() == 0) {
            BaseDatosComponentes.insertarProcesadores();
        }

        // Coger los paquetes enviados de la actividad anterior

        // Codigo para los ListView de Intel
        botonIntel.setOnClickListener(view -> {
            switch (General.rangoElegido) {
                case 1:
                    procesadores = BaseDatosComponentes.getProcesadorRango(1, "INTEL");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                case 2:
                    procesadores = BaseDatosComponentes.getProcesadorRango(2, "INTEL");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                case 3:
                    procesadores = BaseDatosComponentes.getProcesadorRango(3, "INTEL");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                default:
                    break;
            }
        });
        // Codigo para los ListView de AMD
        botonAMD.setOnClickListener(view -> {
            switch (General.rangoElegido) {
                case 1:
                    procesadores = BaseDatosComponentes.getProcesadorRango(1, "AMD");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                case 2:
                    procesadores = BaseDatosComponentes.getProcesadorRango(2, "AMD");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                case 3:
                    procesadores = BaseDatosComponentes.getProcesadorRango(3, "AMD");
                    adaptadorProcesadores = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1, procesadores);
                    listaProcesadores.setAdapter(adaptadorProcesadores);
                    break;
                default:
                    break;
            }
        });
        // Codigo ejecutado una vez se pulsa el item del listview
        listaProcesadores.setOnItemClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorProcesador = partes[0];
                General.idProcesador = Integer.parseInt(identificadorProcesador);
                pasarPantalla = new Intent(SecondActivity.this, ThirdActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        listaProcesadores.setOnItemLongClickListener((parent, view, position, l) -> {
            contenidoItem = parent.getItemAtPosition(position).toString();
            partes = contenidoItem.split(".-");
            if (partes.length > 1) {
                identificadorProcesador = partes[0];
            }
            infoProcesadores = BaseDatosComponentes.getProcesadorInfo(Integer.parseInt(identificadorProcesador));
            convertirAString();
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
            builder.setMessage("INFORMACION DEL COMPONENTE\n" + str);
            AlertDialog informacion = builder.create();
            informacion.show();
            sb.delete(0, sb.length());
            return true;
        });
        botonVolver.setOnClickListener(view -> {
            pasarPantalla = new Intent(SecondActivity.this, FirstActivity.class);
            finish();
            startActivity(pasarPantalla);
        });

    }

    public void convertirAString() {
        for (Object s : infoProcesadores) {
            sb.append(s);
        }
        str = sb.toString();
    }

}