package com.example.behealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    String bajo = "Nivel de estrés: bajo o inexistente.\n\n Estás más tranquilo que vaca en feria vegana. \n " +
            "En ocasiones puedes sentir nervios o intranquilidad, pero en general lo llevas bien. Tienes una " +
            "ansiedad dentro de lo esperable, y sabes gestionarla. (no todo el mundo puede decir lo mismo).";

    String moderado = "Nivel de estrés: moderado.\n\n Tus niveles de estrés se sitúan dentro del límite de normalidad. \n " +
            "Puede que tiendas a ser una persona más nerviosa, o que se preocupa fácilmente. Si ha aparecido algo puntual en" +
            " tu vida ultimamente que te pone en este estado, quizá sea un buen momento de examinarlo.";

    String alto = "Nivel de estrés: muy elevado.\n\n Estás más estresado que el fontanero del Titanic. \n " +
            "Es primordial que aprendas a regularlo. Un nivel de estrés tan elevado no te va a permitir vivir con"
            + "bienestar. Vivir con un alto grado de tensión y preocupación ante lo que sucede o pueda suceder, no es calidad de vida.";
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultados);

        Intent i = this.getIntent();
        Bundle extra = i.getExtras();

        txt1 = findViewById(R.id.textp);
        txt2 = findViewById(R.id.textr);

        r = Integer.parseInt(extra.getString("puntos"));

        if (r >= 0 && r <= 15) {
            txt1.setText("Puntaje Obtenido: " + String.valueOf(r) + " / 60");
            txt2.setText(bajo);

        }

        if (r >= 16 && r <= 40) {
            txt1.setText("Puntaje Obtenido: " + String.valueOf(r) + " / 60");
            txt2.setText(moderado);

        }

        if (r >= 41 && r <= 60) {
            txt1.setText("Puntaje Obtenido: " + String.valueOf(r) + " / 60");
            txt2.setText(alto);
        }


    }

    public void Regresar(View view) {
        Intent intent = new Intent(getApplicationContext(), Principal.class);
        startActivity(intent);
        Toast.makeText(this, "Regresando al inicio", Toast.LENGTH_SHORT).show();
    }
}