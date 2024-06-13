package com.example.behealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    Toolbar toolbar0;
    DrawerLayout drawLyt;
    BarChart graf;
    Cursor cursor;
    DataBase db;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        db = new DataBase(this, "DbRegistro", null, 1);

        graf = findViewById(R.id.grafica);

        List<BarEntry> entradas = new ArrayList<>();
        List<String> etiquetas = new ArrayList<>();
        //final String[] labels = new String[]{"16/07/2022"};

        cursor = db.viewData();


        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No hay datos almacenados ", Toast.LENGTH_SHORT).show();
        } else {

            while (cursor.moveToNext()) {

                entradas.add(new BarEntry(x, Integer.parseInt(cursor.getString(1))));
                etiquetas.add(cursor.getString(0));
                x = x + 1;


            }
            BarDataSet datos = new BarDataSet(entradas, "Gráfica de consumo diario de agua");
            BarData data = new BarData(datos);
            XAxis xAxis = graf.getXAxis();
            xAxis.setGranularity(1f);
            xAxis.setGranularityEnabled(true);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            graf.getXAxis().setValueFormatter(new IndexAxisValueFormatter(etiquetas));
            data.setBarWidth(0.9f);
            graf.getDescription().setEnabled(false);
            graf.setData(data);
            graf.setFitBars(true);
            graf.invalidate();
        }


        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));

        drawLyt = findViewById(R.id.lyt1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(3);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);

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