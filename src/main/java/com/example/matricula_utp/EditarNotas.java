package com.example.matricula_utp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;


import java.util.ArrayList;
import java.util.List;

public class EditarNotas extends AppCompatActivity {

    ListView calificaciones;
    TextView user;
    List<notas>notass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_notas);
        Intent intent = getIntent();
        String nombreUsuario = intent.getStringExtra("nombreUsuario");

        IniciarControles();
        user.setText(nombreUsuario);
        LoadListViewTemplate(LoadNotasArray());
    }

    public void IniciarControles(){
        calificaciones = findViewById(R.id.lstcalificaciones);
        user = findViewById(R.id.usuario);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if(data != null){
                String materia = data.getStringExtra("Materia");
                String semestre = data.getStringExtra("Semestre");
                String nota = data.getStringExtra("Nota");
                int N = Integer.parseInt(nota);
                int drawableId;

                String abcCalificacion= "";

                //If-else para colocar las calificaciones ABC
                if(N>=91){
                    abcCalificacion = "A";
                } else if (N>=81) {
                    abcCalificacion = "B";
                } else if (N>=71) {
                    abcCalificacion = "C";
                } else if (N>=61) {
                    abcCalificacion = "D";
                }else {
                    abcCalificacion = "F";
                }

                //If-else para acomodar las imagenes de aprob/desapro
                if (N >= 71) {
                    drawableId = R.drawable.ganchito_verde;
                } else {
                    drawableId = R.drawable.reprobado;
                }

                //If-else para acomodar las imagenes de la materia
                int nombreMateria = 0 ;
                if(materia == "Invs. Operc"){
                    nombreMateria = R.drawable.inves_operac;
                } else if (materia == "Org. Comp") {
                    nombreMateria = R.drawable.org_comp;
                } else if (materia == "Desarrollo V") {
                    nombreMateria = R.drawable.desarrollo_de_software;
                } else if (materia == "Desarrollo VI") {
                    nombreMateria = R.drawable.desarrollovi_perfil;
                }else {
                    nombreMateria = R.drawable.desarrollo_de_software;
                }

                notas nuevaNota = new notas(nombreMateria, materia, semestre, abcCalificacion, drawableId);
                notass.add(nuevaNota);
                ((list_view_adapter) calificaciones.getAdapter()).notifyDataSetChanged();
            }
        }
    }


    public void AgregarNuevaNota(View view){
        Intent cal = new Intent(this, Crear_Notas.class);
        startActivityForResult(cal, 1);


    }

    private void LoadListViewTemplate(List<notas> notasList) {
        list_view_adapter adapter = new list_view_adapter(this, notasList);
        calificaciones.setAdapter(adapter);
    }


    private List<notas> LoadNotasArray(){
        notass = new ArrayList<>();
        notass.add(new notas(R.drawable.inves_operac,  "Invs. Operc", "Semestre II", "A", R.drawable.ganchito_verde));
        notass.add(new notas(R.drawable.org_comp, "Org. Comp", "Semestre IV", "A", R.drawable.ganchito_verde));
        notass.add(new notas( R.drawable.desarrollo_de_software, "Desarrollo V", "Semestre IV", "A", R.drawable.ganchito_verde));
        notass.add(new notas( R.drawable.desarrollovi_perfil, "Desarrollo VI", "Semestre V", "A", R.drawable.ganchito_verde));
        notass.add(new notas(R.drawable.desarrollo_de_software, "Ing. Software", "Semestre VI", "F", R.drawable.reprobado));
        return notass;
    }
}