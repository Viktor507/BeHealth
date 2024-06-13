package com.example.behealth;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static java.lang.String.valueOf;

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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class RegistroAgua extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    EditText peso;
    Button confirmar;
    Button guardar;
    Double x = 18.8;
    RelativeLayout lytd;
    RelativeLayout lytp;
    TextView txt;
    int meta;
    ImageView img;
    TextView txtAcum;
    Integer target = 300;
    Integer Acum;
    String k1;
    String k2;
    String k3;
    DataBase db;
    Toolbar toolbar0;
    DrawerLayout drawLyt;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registrar);

        db = new DataBase(this, "DbRegistro", null, 1);

        peso = findViewById(R.id.et_kilos);
        confirmar = findViewById(R.id.btn_ingresar);
        lytd = findViewById(R.id.lytdatos);
        lytp = findViewById(R.id.lyt_principal);
        txt = findViewById(R.id.txt_aguameta);
        img = findViewById(R.id.imgv1);
        txtAcum = findViewById(R.id.txt_aguaconsumida);
        guardar = findViewById(R.id.btn_guardarreg);

        mp = MediaPlayer.create(this, R.raw.sfx);

        toolbar0 = findViewById(R.id.tb0);
        setSupportActionBar((Toolbar) findViewById(R.id.tb0));

        drawLyt = findViewById(R.id.lyt1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawLyt, toolbar0, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLyt.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nvg1);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(2);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawLyt.addDrawerListener(this);


        SharedPreferences pf1 = getSharedPreferences("CantidadA", Context.MODE_PRIVATE);
        k1 = ("" + pf1.getString("LlaveA", String.valueOf(0)));
        txt.setText(k1);

        SharedPreferences pf2 = getSharedPreferences("Acumulacion", Context.MODE_PRIVATE);
        k2 = ("" + pf2.getString("Acum", String.valueOf(0)));
        txtAcum.setText(k2);

        SharedPreferences pf3 = getSharedPreferences("Vaso", Context.MODE_PRIVATE);
        k3 = ("" + pf3.getString("Cant", String.valueOf(0)));

        if (!k3.equals("0")) {
            target = Integer.parseInt(k3);
        } else {
            target = 300;
        }


        if (!k1.equals("0")) {
            lytd.setVisibility(INVISIBLE);
            lytp.setVisibility(VISIBLE);
        } else {
            lytd.setVisibility(VISIBLE);
            lytp.setVisibility(INVISIBLE);
        }


        //método para agregar agua
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pf2 = getSharedPreferences("Acumulacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = pf2.edit();

                mp.start();


                if (!txtAcum.getText().toString().equals("0")) {
                    Acum = target + Integer.parseInt(txtAcum.getText().toString());
                    Toast.makeText(getApplicationContext(), "¡Se ha registrado un vaso de agua!", Toast.LENGTH_SHORT).show();


                } else {
                    Acum = target;
                    Toast.makeText(getApplicationContext(), "¡Se ha registrado el primer vaso del día!", Toast.LENGTH_SHORT).show();

                }

                editor2.putString("Acum", String.valueOf(Acum));
                editor2.apply();
                txtAcum.setText(String.valueOf(Acum));


            }
        });


        //método para quitar agua
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                SharedPreferences pf2 = getSharedPreferences("Acumulacion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = pf2.edit();

                if (Integer.parseInt(txtAcum.getText().toString()) >= target) {
                    Acum = Integer.parseInt(txtAcum.getText().toString()) - target;
                    editor2.putString("Acum", String.valueOf(Acum));
                    editor2.apply();
                    txtAcum.setText(String.valueOf(Acum));


                } else {
                    Toast.makeText(getApplicationContext(), "La cantidad de agua consumida no se puede disminuir más", Toast.LENGTH_SHORT).show();

                }


                return true;
            }
        });


        //método para guardar un registro
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alert = new AlertDialog.Builder(guardar.getContext());
                alert.setTitle("Guardar registro");
                alert.setMessage("¿Desea guardar un registro para el día de hoy?");
                alert.setCancelable(false);

                alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alert, int id) {

                        if (!txtAcum.getText().toString().equals("0")) {
                            SQLiteDatabase bd = db.getReadableDatabase();
                            Cursor cursor = bd.rawQuery("SELECT * FROM Consumo WHERE fecha='" + Fecha() + "'", null);

                            if (cursor.moveToNext()) {
                                Toast.makeText(getApplicationContext(), "Ya hiciste un registro para el día de hoy, espera a mañana", Toast.LENGTH_LONG).show();
                            } else {

                                db.insertar(Fecha(), String.valueOf(Acum));
                                Toast.makeText(getApplicationContext(), "Registro de agua para el día de hoy guardado exitosamente", Toast.LENGTH_SHORT).show();
                            }


                            SharedPreferences pf2 = getSharedPreferences("Acumulacion", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor2 = pf2.edit();
                            editor2.putString("Acum", String.valueOf(0));
                            txtAcum.setText(String.valueOf(0));
                            editor2.apply();
                            cursor.close();
                            db.close();


                        } else {

                            Toast.makeText(getApplicationContext(), "No se puede registrar nada, por que la cantidad consumida es 0", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alert, int id) {
                        Toast t = Toast.makeText(getApplicationContext(), "¡Guardado de registro, cancelado!", Toast.LENGTH_SHORT);
                        t.show();
                    }
                });
                alert.show();


            }
        });

        //método para calcular la cantidad de agua
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pf1 = getSharedPreferences("CantidadA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pf1.edit();

                if (peso.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El campo está vacío", Toast.LENGTH_SHORT).show();

                } else {

                    int cantidad = Integer.parseInt(peso.getText().toString());

                    if (cantidad >= x) {
                        meta = cantidad * 35;
                        lytd.setVisibility(INVISIBLE);
                        lytp.setVisibility(VISIBLE);
                        txt.setText(valueOf(meta));
                        editor.putString("LlaveA", String.valueOf(meta));
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "El peso ha sido registrado, mostrando consumo ideal...", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "El peso ingresado es relativamente bajo, el peso debe ser mayor a 40lbs(18.8kg)", Toast.LENGTH_SHORT).show();
                        peso.setText("");
                        lytd.setVisibility(VISIBLE);
                        lytp.setVisibility(INVISIBLE);
                    }

                }

            }

        });


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

    public String Fecha() {
        String fecha;
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int dia = today.monthDay;
        int mes = today.month + 1;
        int año = today.year;

        fecha = dia + "/" + mes + "/" + año;

        return fecha;
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