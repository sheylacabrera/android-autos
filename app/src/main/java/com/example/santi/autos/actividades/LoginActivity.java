package com.example.santi.autos.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.santi.autos.R;

import com.example.santi.autos.controladores.*;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    private EditText etUsuario;
    private EditText etPassword;
    private AdministradorLogin administradorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        administradorLogin = new AdministradorLoginImpl();
        etUsuario = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
    }

    public void aceptarOnCLick(View v) {
        try {
            String user = etUsuario.getText().toString();
            String pwd = etPassword.getText().toString();
            if (administradorLogin.login(user, pwd)) {
                Intent intent = new Intent(LoginActivity.this, ShowProductsActivity.class);
                intent.putExtra("ced",user);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Existe un problema con el componente, intente nuevamente", Toast.LENGTH_LONG).show();
        }
    }
}

