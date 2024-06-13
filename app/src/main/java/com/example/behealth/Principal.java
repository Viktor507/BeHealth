package com.example.behealth;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {


    DrawerLayout drawLyt;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar0;
    TextView txt1;
    TextView txt2;
    String m1 = "El que tiene salud, tiene esperanza; el que tiene esperanza, lo tiene todo.";
    String m2 = "La actividad física no es solo una de las claves más importantes para un cuerpo saludable, es la base de una actividad dinámica y creativa.";
    String m3 = "El secreto para tener buena salud es que el cuerpo se agite y que la mente repose.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        txt1 = findViewById(R.id.txtbienvenida);
        txt2 = findViewById(R.id.txtmensaje);

        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));


        drawLyt = findViewById(R.id.lyt1);
        toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);

        Vista1();

    }

    @Override
    public void onBackPressed() {
        if (drawLyt.isDrawerOpen(GravityCompat.START)) {
            drawLyt.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.opc0: { //inicio

            }
            break;

            case R.id.opc1: { //calculadora
                Intent intent = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent);


            }
            break;

            case R.id.opc2: { //registrar
                Intent intent = new Intent(getApplicationContext(), RegistroAgua.class);
                startActivity(intent);


            }

            break;
            case R.id.opc3: {//registro
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);

            }
            break;

            case R.id.opc4: {//test
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);


            }
            break;

            case R.id.opc5: {//configuración
                Intent intent = new Intent(getApplicationContext(), Configuracion.class);
                startActivity(intent);


            }
            break;

            case R.id.opc6: {//salir
                Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show();
                finishAffinity();


            }
            break;

            default:
                throw new IllegalArgumentException("Error");
        }


        drawLyt.closeDrawer(GravityCompat.START);

        return true;
    }

    public void Vista1() {
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt2.setText(m1);

            }

            public void onFinish() {
                    Vista2();
            }


        }.start();

    }

    public void Vista2() {
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt2.setText(m2);

            }

            public void onFinish() {

                Vista3();

            }


        }.start();

    }


    public void Vista3() {
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt2.setText(m3);

            }

            public void onFinish() {

                Vista1();

            }


        }.start();

    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

}