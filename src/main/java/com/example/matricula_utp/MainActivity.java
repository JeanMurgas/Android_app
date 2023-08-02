package com.example.matricula_utp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    EditText cedula;
    EditText contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarControles();
        Usuarios();
    }

    private void Usuarios(){
        try {
            /*SharedPreferences prf = getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prf.edit();
            editor.putString("login", "Jean");
            editor.putString("pass", "333");
            editor.commit();*/

            //Este es para el archivo
            OutputStreamWriter writter = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_PRIVATE));
            writter.write("8-983-2358"+"~"+"4321"+"~"+"Jean Carlos"+"~");
            writter.write("9-99-999"+"~"+"777"+"~"+"Julio Iglesias");
            writter.close();

        }catch (Exception e){

        }

    }

    private void IniciarControles(){
        cedula = findViewById(R.id.txtcedula);
        contrasena = findViewById(R.id.txtcontrasena);
    }

    public void ValidarIngreso(View v){

        IniciarSesion();
    }

    private void IniciarSesion(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
            String[] credenciales = bf.readLine().split("~");
            bf.close();

            if (cedula.getText().toString().equals(credenciales[0])&& contrasena.getText().toString().equals(credenciales[1])){
                Toast.makeText(getApplicationContext(),"Login exitoso", Toast.LENGTH_LONG).show();
                String nombreUsuario = credenciales[2];
                Intent i = new Intent(this, Pantalla2.class );
                i.putExtra("name", nombreUsuario);
                startActivity(i);
            }else if (cedula.getText().toString().equals(credenciales[3])&& contrasena.getText().toString().equals(credenciales[4])){
                Toast.makeText(getApplicationContext(),"Login exitoso", Toast.LENGTH_LONG).show();
                String nombreUsuario = credenciales[5];
                Intent i = new Intent(this, Pantalla2.class);
                i.putExtra("nombreUsuario", nombreUsuario);
                startActivity(i);
            }else if(cedula.getText().toString().isEmpty() || contrasena.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Escriba su cédula y contraseña",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Cédula o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }


        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Login sin éxito", Toast.LENGTH_LONG).show();
        }
    }

}