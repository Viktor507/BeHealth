package com.example.behealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Test extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    Toolbar toolbar0;
    DrawerLayout drawLyt;
    RadioGroup r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    RadioGroup r11, r12, r13, r14, r15, r16, r17, r18, r19, r20;
    int Acum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        r1 = findViewById(R.id.rg1);
        r2 = findViewById(R.id.rg2);
        r3 = findViewById(R.id.rg3);
        r4 = findViewById(R.id.rg4);
        r5 = findViewById(R.id.rg5);
        r6 = findViewById(R.id.rg6);
        r7 = findViewById(R.id.rg7);
        r8 = findViewById(R.id.rg8);
        r9 = findViewById(R.id.rg9);
        r10 = findViewById(R.id.rg10);
        r11 = findViewById(R.id.rg11);
        r12 = findViewById(R.id.rg12);
        r13 = findViewById(R.id.rg13);
        r14 = findViewById(R.id.rg14);
        r15 = findViewById(R.id.rg15);
        r16 = findViewById(R.id.rg16);
        r17 = findViewById(R.id.rg17);
        r18 = findViewById(R.id.rg18);
        r19 = findViewById(R.id.rg19);
        r20 = findViewById(R.id.rg20);


        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));

        drawLyt = findViewById(R.id.lyt1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(4);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);


    }


    public void Guardar(View view) {

        if (r1.getCheckedRadioButtonId() != -1 && r2.getCheckedRadioButtonId() != -1 && r3.getCheckedRadioButtonId() != -1 && r4.getCheckedRadioButtonId() != -1 &&
                r5.getCheckedRadioButtonId() != -1 && r6.getCheckedRadioButtonId() != -1 && r7.getCheckedRadioButtonId() != -1 && r8.getCheckedRadioButtonId() != -1 &&
                r9.getCheckedRadioButtonId() != -1 && r10.getCheckedRadioButtonId() != -1 && r11.getCheckedRadioButtonId() != -1 && r12.getCheckedRadioButtonId() != -1 &&
                r13.getCheckedRadioButtonId() != -1 && r14.getCheckedRadioButtonId() != -1 && r15.getCheckedRadioButtonId() != -1 && r16.getCheckedRadioButtonId() != -1 &&
                r17.getCheckedRadioButtonId() != -1 && r18.getCheckedRadioButtonId() != -1 && r19.getCheckedRadioButtonId() != -1 && r20.getCheckedRadioButtonId() != -1) {

            switch (r1.getCheckedRadioButtonId()) {

                case R.id.RB1: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB2: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB3: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB4: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r2.getCheckedRadioButtonId()) {

                case R.id.RB5: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB6: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB7: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB8: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r3.getCheckedRadioButtonId()) {

                case R.id.RB9: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB10: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB11: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB12: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r4.getCheckedRadioButtonId()) {

                case R.id.RB13: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB14: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB15: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB16: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r5.getCheckedRadioButtonId()) {

                case R.id.RB17: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB18: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB19: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB20: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r6.getCheckedRadioButtonId()) {

                case R.id.RB21: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB22: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB23: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB24: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r7.getCheckedRadioButtonId()) {

                case R.id.RB25: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB26: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB27: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB28: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r8.getCheckedRadioButtonId()) {

                case R.id.RB29: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB30: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB31: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB32: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r9.getCheckedRadioButtonId()) {

                case R.id.RB33: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB34: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB35: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB36: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r10.getCheckedRadioButtonId()) {

                case R.id.RB37: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB38: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB39: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB40: {
                    Acum = Acum + 3;

                }
                break;

            }
            switch (r11.getCheckedRadioButtonId()) {

                case R.id.RB41: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB42: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB43: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB44: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r12.getCheckedRadioButtonId()) {

                case R.id.RB45: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB46: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB47: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB48: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r13.getCheckedRadioButtonId()) {

                case R.id.RB49: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB50: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB51: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB52: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r14.getCheckedRadioButtonId()) {

                case R.id.RB53: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB54: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB55: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB56: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r15.getCheckedRadioButtonId()) {

                case R.id.RB57: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB58: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB59: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB60: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r16.getCheckedRadioButtonId()) {

                case R.id.RB61: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB62: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB63: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB64: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r17.getCheckedRadioButtonId()) {

                case R.id.RB65: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB66: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB67: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB68: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r18.getCheckedRadioButtonId()) {

                case R.id.RB69: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB70: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB71: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB72: {
                    Acum = Acum + 3;

                }
                break;

            }

            switch (r19.getCheckedRadioButtonId()) {

                case R.id.RB73: {

                    Acum = Acum + 0;
                }
                break;


                case R.id.RB74: {
                    Acum = Acum + 1;

                }
                break;

                case R.id.RB75: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB76: {
                    Acum = Acum + 3;

                }
                break;

            }


            switch (r20.getCheckedRadioButtonId()) {

                case R.id.RB77: {
                    Acum = Acum + 0;

                }
                break;


                case R.id.RB78: {

                    Acum = Acum + 1;
                }
                break;

                case R.id.RB79: {

                    Acum = Acum + 2;
                }
                break;

                case R.id.RB80: {
                    Acum = Acum + 3;

                }
                break;

            }

            Toast.makeText(this, "Mostrando resultados...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Resultados.class);
            i.putExtra("puntos", String.valueOf(Acum));
            startActivity(i);
            Acum = 0;
            r1.clearCheck();
            r2.clearCheck();
            r3.clearCheck();
            r4.clearCheck();
            r5.clearCheck();
            r6.clearCheck();
            r7.clearCheck();
            r8.clearCheck();
            r9.clearCheck();
            r10.clearCheck();
            r11.clearCheck();
            r12.clearCheck();
            r13.clearCheck();
            r14.clearCheck();
            r15.clearCheck();
            r16.clearCheck();
            r17.clearCheck();
            r18.clearCheck();
            r19.clearCheck();
            r20.clearCheck();
        } else {
            Toast.makeText(this, "¡Se ha dejado preguntas sin contestar!", Toast.LENGTH_SHORT).show();

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