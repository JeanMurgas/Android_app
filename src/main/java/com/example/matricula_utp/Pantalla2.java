package com.example.matricula_utp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    String nombreUsuario;
    RadioGroup Pestanas;
    String url= "http://utp.ac.pa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        IniciarRBG();
    }

    public void IniciarRBG(){
        Pestanas = findViewById(R.id.rbgPestanas);
    }

    public void Entrar(View v){
        int checkedId = Pestanas.getCheckedRadioButtonId();

        if (checkedId == R.id.rbgEstudiante) {
            Intent a = new Intent(this, liestview_mostrar.class );
            nombreUsuario = a.getStringExtra("name");
            a.putExtra("name", nombreUsuario);
            startActivity(a);

        } else if (checkedId == R.id.rbgEstudianteSLU) {
            Uri link = Uri.parse(url);
            Intent call = new Intent(Intent.ACTION_VIEW, link);
            startActivity(call);

        } else if (checkedId == R.id.rbgProfesor) {
            Intent p = new Intent(this, EditarNotas.class );
            startActivity(p);
        } else {
            Toast.makeText(getApplicationContext(), "Escoja una opción", Toast.LENGTH_LONG).show();
        }
    }

}