package com.example.lba02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    int cantidad = 0;
    Persona[] listaRegistrados = new Persona[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtApellidoPaterno = findViewById(R.id.ApellidoPaterno);
        EditText edtApellidoMaterno = findViewById(R.id.ApellidoMaterno);
        EditText edtNombres = findViewById(R.id.Nombres);
        EditText edtColegio = findViewById(R.id.ColegioProcedencia);
        EditText edtNacimiento = findViewById(R.id.fechaNacimiento);
        Button btnRegistrar = (Button) findViewById(R.id.Registrar);
        Button btnListar = (Button) findViewById(R.id.Listar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apPaterno = edtApellidoPaterno.getText().toString();
                String apMaterno = edtApellidoMaterno.getText().toString();
                String nombres = edtNombres.getText().toString();
                String nacimiento = edtNacimiento.getText().toString();
                String colegio = edtColegio.getText().toString();

                Persona aux = new Persona(apPaterno, apMaterno, nombres, nacimiento, colegio);
                listaRegistrados[cantidad] = aux;
                Log.d(TAG, "Registro exitoso");
                aux.imp();

                cantidad++;
            }
        });
        btnListar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < cantidad; i++){
                    Log.d(TAG, ""+listaRegistrados[i]);
                }
            }
        }));
    }
}
class Persona {
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Nombres;
    String Nacimiento;
    String Colegio;

    public Persona(String ap, String am, String n, String nac, String c){
        ApellidoPaterno = ap;
        ApellidoMaterno = am;
        Nombres = n;
        Nacimiento = nac;
        Colegio = c;
    }
    public void imp() {
        System.out.println(" "+ApellidoPaterno+" "+ApellidoMaterno+" "+Nombres+" "+Nacimiento+" "+Colegio);
    }
}