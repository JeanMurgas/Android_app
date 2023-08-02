package com.example.matricula_utp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class liestview_mostrar extends AppCompatActivity {
    ListView calificaciones;
    TextView user;
    List<notas>notass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_notas);
        IniciarControles();

        Intent i = getIntent();
        String nombreUsuario = i.getStringExtra("name");
        Toast.makeText(getApplicationContext(),nombreUsuario, Toast.LENGTH_LONG).show();
        user.setText(nombreUsuario);
        LoadListViewTemplate();
        LoadNotasArray();
    }

    public void IniciarControles(){
        calificaciones = findViewById(R.id.lstcalificaciones);
        user = findViewById(R.id.usuario);
    }

    private void LoadListViewTemplate() {
        list_view_adapter adapter = new list_view_adapter(this, LoadNotasArray());
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
