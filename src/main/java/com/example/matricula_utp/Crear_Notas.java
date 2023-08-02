package com.example.matricula_utp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class Crear_Notas extends AppCompatActivity {

    Spinner mate, seme;
    EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_notas);

        IniciarControles();
        ConfigurarMateSpinner();
        ConfigurarSemeSpinner();
    }

    public void IniciarControles(){
        mate = findViewById(R.id.spMateria);
        seme = findViewById(R.id.spSemestre);
        nota = findViewById(R.id.txtNota);
    }

    public void ConfigurarMateSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerMateria, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mate.setAdapter(adapter);
    }

    public void ConfigurarSemeSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerSemestre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seme.setAdapter(adapter);
    }

    public void AgregarNota(View v){
        String materiaSeleccionada = mate.getSelectedItem().toString();
        String semestreSeleccionado = seme.getSelectedItem().toString();
        String notaIngresada = nota.getText().toString();


        Intent envio = new Intent();
        envio.putExtra("Materia", materiaSeleccionada);
        envio.putExtra("Semestre", semestreSeleccionado);
        envio.putExtra("Nota", notaIngresada);
        setResult(RESULT_OK, envio);
        finish();
    }
}