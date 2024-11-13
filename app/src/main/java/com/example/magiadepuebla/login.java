package com.example.magiadepuebla;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private Button bEntrar;
    private EditText etCorreo, etContrasenia;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        etCorreo = findViewById(R.id.etCorreoLogin);
        etContrasenia = findViewById(R.id.etContraseniaLogin);
        bEntrar = findViewById(R.id.bIngresar);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etCorreo.getText().toString().trim();
                String contrasena = etContrasenia.getText().toString().trim();
                
                if(email.isEmpty() || contrasena.isEmpty()){
                    Toast.makeText(login.this, "Por favor, ingresa ambos campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginUser(email,contrasena);
            }
        });
    }

    private void loginUser(String email, String contrasena){
        mAuth.signInWithEmailAndPassword(email,contrasena).addOnCompleteListener(this,task -> {
            if (task.isSuccessful()){
                FirebaseUser user = mAuth.getCurrentUser();
                Toast.makeText(login.this, "¡Bienvenido " + user.getEmail() + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(login.this, "Error en el inicio de sesión. Revisa tu correo o contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }
}