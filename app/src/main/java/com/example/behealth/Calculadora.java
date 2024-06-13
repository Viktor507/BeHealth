package com.example.behealth;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Calculadora extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    EditText etpeso;
    EditText etaltura;
    EditText imc;
    TextView rango;

    Double peso;
    Double altura;
    Double indice;

    String r;

    Toolbar toolbar0;
    DrawerLayout drawLyt;

    String longitud = "###,###.##";
    DecimalFormat decimalFormat = new DecimalFormat(longitud);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculadora);

        etaltura = findViewById(R.id.et_altura);
        etpeso = findViewById(R.id.et_peso);
        imc = findViewById(R.id.et_resultado);
        rango = findViewById(R.id.txtrango);

        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));

        drawLyt = findViewById(R.id.lyt1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(1);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);

    }

    public void CalcularIMC(View v) {

        String valid1 = etpeso.getText().toString();
        String valid2 = etaltura.getText().toString();

        if (!valid1.equals("") && !valid2.equals("")) {

            peso = Double.parseDouble(etpeso.getText().toString());
            altura = Double.parseDouble(etaltura.getText().toString());

            if (peso > 0 && altura > 0) {

                indice = peso / (altura * altura);


                if (indice <= 15) {
                    r = decimalFormat.format(indice);
                    rango.setText("Delgadez muy severa");
                    imc.setText(r);
                }

                if (indice > 15 && indice <= 15.9) {
                    r = decimalFormat.format(indice);
                    rango.setText("Delgadez severa");
                    imc.setText(r);
                }

                if (indice >= 16 && indice <= 18.4) {
                    r = decimalFormat.format(indice);
                    rango.setText("Delgadez");
                    imc.setText(r);
                }

                if (indice >= 18.5 && indice <= 24.9) {
                    r = decimalFormat.format(indice);
                    rango.setText("Peso Saludable");
                    imc.setText(r);
                }

                if (indice >= 25 && indice <= 29.9) {
                    r = decimalFormat.format(indice);
                    rango.setText("Sobrepeso");
                    imc.setText(r);
                }

                if (indice >= 30 && indice <= 34.9) {
                    r = decimalFormat.format(indice);
                    rango.setText("Obesidad moderada");
                    imc.setText(r);
                }

                if (indice >= 35 && indice <= 39.9) {
                    r = decimalFormat.format(indice);
                    rango.setText("Obesidad severa");
                    imc.setText(r);
                }

                if (indice >= 40) {
                    r = decimalFormat.format(indice);
                    rango.setText("Obesidad mórbida");
                    imc.setText(r);
                }
            } else if (peso == null || altura == null) {

                Toast.makeText(this, "No ha ingresado ningun valor", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "No ha ingresado ningun valor", Toast.LENGTH_SHORT).show();
        } //fin de la validación
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