package com.example.santi.autos.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.santi.autos.R;
import com.example.santi.autos.controladores.AdministradorVentas;
import com.example.santi.autos.controladores.AdministradorVentasImpl;
import com.example.santi.autos.entidades.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class ShowCarsActivity extends Activity {
    private GridView lv;
    private AdministradorVentas administradorVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cars);

        administradorVentas = AdministradorVentasImpl.getAdministradorVentas();
        lv = (GridView) findViewById(R.id.gShowCarVIew);

        List<String> datos = new ArrayList<>();
        try {
            for (Vehiculo v : administradorVentas.listar()) {
                datos.add(v.getCodigo() + " - " + v.getPlaca());
            }
        } catch (Exception e) {
            //algun problema en recuperar datos
            return;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        lv.setAdapter(adapter);
    }

    public void addCarOnCLick(View v) {
        Intent intent = new Intent(ShowCarsActivity.this, AddCarActivity.class);
        startActivity(intent);
        finish();
    }
}
