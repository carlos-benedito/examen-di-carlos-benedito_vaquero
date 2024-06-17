package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button mAlertBtn;
    private Button mEntrarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEntrarBtn = findViewById(R.id.button);


        // Configurar el OnClickListener para el botón "entrar"
        mEntrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar MainActivity2
                Intent intent = new Intent(Login.this, RecyclerView.class);
                startActivity(intent);
            }
        });
    }
}