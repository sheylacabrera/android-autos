package com.example.santi.autos.actividades;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.santi.autos.R;
import com.example.santi.autos.controladores.AdministradorLogin;
import com.example.santi.autos.controladores.AdministradorLoginImpl;
import com.example.santi.autos.controladores.AdministradorVentas;
import com.example.santi.autos.controladores.AdministradorVentasImpl;
import com.example.santi.autos.entidades.Vehiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class AddCarActivity extends AppCompatActivity {

    private EditText etPlate;
    private EditText etBrand;
    private EditText etColor;
    private EditText etDate;
    DatePickerDialog datePickerDialog;
    private CheckBox cbState;
    private Vehiculo vehiculo;

    private AdministradorVentas administradorVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        administradorVentas = AdministradorVentasImpl.getAdministradorVentas();
        etPlate = (EditText) findViewById(R.id.etPlate);
        etBrand = (EditText) findViewById(R.id.etBrand);
        etColor = (EditText) findViewById(R.id.etColor);
        etDate = (EditText) findViewById(R.id.etDate);
        cbState = (CheckBox) findViewById(R.id.cbState);
        // perform click event on edit text
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddCarActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                etDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        vehiculo = new Vehiculo();
    }

    public void addCarOnClick(View v) {
        String plate = etPlate.getText().toString();
        String brand = etBrand.getText().toString();
        String color = etColor.getText().toString();
        String dateString = etDate.getText().toString();
        boolean state = cbState.isChecked();
        boolean flag = true;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(dateString);
        } catch (ParseException ex) {
            Toast.makeText(getApplicationContext(), "La fecha no cumple con el formato establecido.", Toast.LENGTH_LONG).show();
            flag = false;
        }
        if (!plate.matches("(^[A-Z]{3})(\\d{4})")){
            Toast.makeText(getApplicationContext(), "La placa no cumple con el formato establecido. Ej. PZS1722", Toast.LENGTH_LONG).show();
            flag = false;
        }
        if (!brand.matches("^[a-zA-Z]+")){
            Toast.makeText(getApplicationContext(), "La marca no es una palabra.", Toast.LENGTH_LONG).show();
            flag = false;
        }
        if (!color.matches("^[a-zA-Z]+")){
            Toast.makeText(getApplicationContext(), "El color no es una palabra.", Toast.LENGTH_LONG).show();
            flag = false;
        }
        Vehiculo vehiculo = new Vehiculo(plate, brand, color, date, state);
        administradorVentas = AdministradorVentasImpl.getAdministradorVentas();
        try {
            if (flag) {
                administradorVentas.crear(vehiculo);
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Existe un problema con el componente, intente nuevamente", Toast.LENGTH_LONG).show();
            flag = false;
        }
        if (flag) {
            Intent intent = new Intent(AddCarActivity.this, ShowCarsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
        }
    }
}