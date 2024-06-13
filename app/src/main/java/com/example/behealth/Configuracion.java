package com.example.behealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Configuracion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    Toolbar toolbar0;
    DrawerLayout drawLyt;
    TextView txteliminar;
    TextView txtregistros;
    TextView mostrar;
    DataBase db;
    RadioGroup rg1;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    String k;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_configuracion);

        db = new DataBase(this, "DbRegistro", null, 1);

        rg1 = findViewById(R.id.radiog1);

        r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        r3 = findViewById(R.id.rb3);
        r4 = findViewById(R.id.rb4);

        txteliminar = findViewById(R.id.txt_op1);
        txtregistros = findViewById(R.id.txt_op2);
        mostrar = findViewById(R.id.txt_info);


        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));

        SharedPreferences pf3 = getSharedPreferences("Vaso", Context.MODE_PRIVATE);
        k = ("" + pf3.getString("Cant", String.valueOf(0)));
        if (!k.equals("0")) {
            mostrar.setText("Valor actual: " + k + "ml");
        } else {
            mostrar.setText("Valor actual: 300ml");
        }

        switch (k) {

            case "150": {
                r1.setChecked(true);

            }
            break;

            case "200": {

                r2.setChecked(true);
            }
            break;

            case "250": {
                r3.setChecked(true);

            }
            break;

            case "300": {

                r4.setChecked(true);
            }
            break;

            default: {
                r1.setChecked(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);

            }

        }

        drawLyt = findViewById(R.id.lyt1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(5);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);
    }


    public void Eliminar(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(txteliminar.getContext());
        alert.setTitle("Eliminacion del peso registrado");
        alert.setMessage("¿Estás seguro que quieres eliminar el peso?");
        alert.setCancelable(false);

        alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface alert, int id) {
                SharedPreferences pf2 = getSharedPreferences("CantidadA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = pf2.edit();

                editor2.putString("LlaveA", String.valueOf(0));
                editor2.apply();

                SharedPreferences pf1 = getSharedPreferences("Acumulacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pf1.edit();

                editor1.putString("Acum", String.valueOf(0));
                editor1.apply();

                Toast t = Toast.makeText(getApplicationContext(), "¡Eliminación exitosa!", Toast.LENGTH_SHORT);
                t.show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface alert, int id) {
                Toast t = Toast.makeText(getApplicationContext(), "¡Eliminación cancelada!", Toast.LENGTH_SHORT);
                t.show();
            }
        });
        alert.show();


    }

    public void EliminarTabla(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(txtregistros.getContext());
        alert.setTitle("Eliminacion de los registros almacenados");
        alert.setMessage("¿Estás seguro que quieres eliminar los registros");
        alert.setCancelable(false);

        alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface alert, int id) {
                db.eliminar();
                Toast t = Toast.makeText(getApplicationContext(), "¡Eliminación de registros exitosa!", Toast.LENGTH_SHORT);
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface alert, int id) {
                Toast t = Toast.makeText(getApplicationContext(), "¡Eliminación cancelada!", Toast.LENGTH_SHORT);
                t.show();
            }
        });
        alert.show();


    }

    public void Seleccionar(View view) {

        SharedPreferences pf = getSharedPreferences("Vaso", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pf.edit();

        switch (rg1.getCheckedRadioButtonId()) {


            case R.id.rb1: {

                if (r1.isChecked() && mostrar.getText().toString().equals("Valor actual: 150ml")) {

                } else {

                    editor.putString("Cant", String.valueOf(150));
                    editor.apply();
                    mostrar.setText("Valor actual: 150ml");
                    Toast t = Toast.makeText(getApplicationContext(), "¡Los cambios han sido aplicados!", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
            break;


            case R.id.rb2: {
                if (r2.isChecked() && mostrar.getText().toString().equals("Valor actual: 200ml")) {
                } else {

                    editor.putString("Cant", String.valueOf(200));
                    editor.apply();
                    mostrar.setText("Valor actual: 200ml");
                    Toast t = Toast.makeText(getApplicationContext(), "¡Los cambios han sido aplicados!", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
            break;

            case R.id.rb3: {
                if (r3.isChecked() && mostrar.getText().toString().equals("Valor actual: 250ml")) {

                } else {
                    mostrar.setText("Valor actual: 250ml");
                    Toast t = Toast.makeText(getApplicationContext(), "¡Los cambios han sido aplicados!", Toast.LENGTH_SHORT);
                    t.show();
                    editor.putString("Cant", String.valueOf(250));
                    editor.apply();
                }
            }
            break;

            case R.id.rb4: {

                if (r4.isChecked() && mostrar.getText().toString().equals("Valor actual: 300ml")) {

                }else{

                    mostrar.setText("Valor actual: 300ml");
                    Toast t = Toast.makeText(getApplicationContext(), "¡Los cambios han sido aplicados!", Toast.LENGTH_SHORT);
                    t.show();
                    editor.putString("Cant", String.valueOf(300));
                    editor.apply();
                }
            }
            break;

            default: {
                Toast t = Toast.makeText(getApplicationContext(), "¡No se ha seleccionado ninguna ópcion!", Toast.LENGTH_SHORT);
                t.show();
            }
            break;

        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.opc0: { //inicio

                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);


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

    @Override
    public void onBackPressed() {
        if (drawLyt.isDrawerOpen(GravityCompat.START)) {
            drawLyt.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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