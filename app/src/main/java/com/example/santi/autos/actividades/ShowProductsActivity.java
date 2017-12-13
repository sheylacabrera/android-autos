package com.example.santi.autos.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.santi.autos.R;
import com.example.santi.autos.controladores.AdministradorVentas;
import com.example.santi.autos.controladores.AdministradorVentasImpl;
import com.example.santi.autos.controladores.ImageAdapter;
import com.example.santi.autos.entidades.Products;

import java.util.ArrayList;
import java.util.List;

public class ShowProductsActivity extends Activity {
    private GridView lv;
    private EditText wm;
    private AdministradorVentas administradorVentas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);

        administradorVentas = AdministradorVentasImpl.getAdministradorVentas();
        lv = (GridView) findViewById(R.id.gShowCarVIew);
        wm = (EditText) findViewById(R.id.welcomeMsgs);
        Bundle b = getIntent().getExtras();
        String value = ""; // or other values
        if(b != null)
            value = b.getString("ced");
        wm.setText("BIENVENIDO QUERIDO AMIGO  " + value + "A LA PASTELERIA ESMERALDITA");
        try {
            lv.setAdapter(new ImageAdapter(this, administradorVentas.listarDatos(), administradorVentas.listarImagen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(ShowProductsActivity.this, "Se ha elegido la opcion " + position,
                        Toast.LENGTH_LONG).show();
            }
        });*/


//        List<String> datos = new ArrayList<>();
//        try {
//            for (Products v : administradorVentas.listar()) {
//                datos.add(v.getNombre());
//            }
//        } catch (Exception e) {
//            //algun problema en recuperar datos
//            return;
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
//        lv.setAdapter(adapter);
    }

    public void addCarOnCLick(View v) {
        Intent intent = new Intent(ShowProductsActivity.this, AddCarActivity.class);
        startActivity(intent);
        finish();
    }
}
