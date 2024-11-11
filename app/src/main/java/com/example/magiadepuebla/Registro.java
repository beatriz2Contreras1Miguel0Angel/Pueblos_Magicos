package com.example.magiadepuebla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {
    private EditText etNombre, etApellidos, etCorreo,etContrasenia,etConfirmaContrasenia;
    private RadioGroup radioGenero;
    private Button bRegistrar;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.et_nombre);
        etApellidos = findViewById(R.id.et_apellidos);
        etCorreo = findViewById(R.id.et_correo);
        etContrasenia = findViewById(R.id.et_contrasenia);
        etConfirmaContrasenia = findViewById(R.id.et_confirma_contrasenia);
        radioGenero = findViewById(R.id.radioGenero);
        bRegistrar= findViewById(R.id.b_registrar);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario(){
        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String correo = etCorreo.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        String confirmaContraseia = etConfirmaContrasenia.getText().toString();

        if (!contrasenia.equals(confirmaContraseia)) {
            Toast.makeText(this, "La Contraseña No Coincide", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedGeneroId = radioGenero.getCheckedRadioButtonId();
        RadioButton selectedGenero = findViewById(selectedGeneroId);
        String genero = selectedGenero !=null ? selectedGenero.getText().toString(): "No Especificado";

        Usuario usuario = new Usuario(nombre, apellidos, correo, contrasenia, confirmaContraseia);

        String userId = mDatabase.push().getKey();
        if(userId != null){
            mDatabase.child("usuarios").child(userId).setValue(usuario).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Registro.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    abrirMenu();
                }else{
                    Toast.makeText(Registro.this, "Error Al Registar", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void abrirMenu(){
        startActivity(new Intent(Registro.this, Menu_Fragment.class));
        finish();
    }
}