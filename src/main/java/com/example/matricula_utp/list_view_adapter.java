package com.example.matricula_utp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class list_view_adapter extends ArrayAdapter<notas> {
    private List<notas> opciones = new ArrayList<>();

    public list_view_adapter(Context context, List<notas> mate) {
        super(context, R.layout.listview_modelo, mate);
        opciones = mate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_modelo, null);

        ImageView PerfilMate = (ImageView) item.findViewById(R.id.imgPerfilMateria);
        PerfilMate.setImageResource(opciones.get(position).getFotoP());

        TextView materia = (TextView) item.findViewById(R.id.txtMateria);
        materia.setText(opciones.get(position).getMateria());

        TextView semestre = (TextView) item.findViewById(R.id.txtSemestre);
        semestre.setText(opciones.get(position).getSemestre());

        TextView nota = (TextView) item.findViewById(R.id.nota);
        nota.setText(opciones.get(position).getNota());

        ImageView ganchito = (ImageView) item.findViewById(R.id.imgGanchito);
        ganchito.setImageResource(opciones.get(position).getFotoAprob());

        return (item);
    }
}
