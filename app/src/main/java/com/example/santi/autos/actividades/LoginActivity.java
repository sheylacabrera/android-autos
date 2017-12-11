package com.example.santi.autos.actividades;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.santi.autos.R;

import java.util.ArrayList;
import java.util.List;

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
                Intent intent = new Intent(LoginActivity.this, ShowCarsActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Existe un problema con el componente, intente nuevamente", Toast.LENGTH_LONG).show();
        }
    }
}

