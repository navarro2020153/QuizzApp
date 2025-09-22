package com.example.quizzapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conectamos con el layout XML
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val btnTrue: Button = findViewById(R.id.btn_true)
        val btnFalse: Button = findViewById(R.id.btn_false)

        // Evento para botón TRUE
        btnTrue.setOnClickListener {
            Toast.makeText(this, "¡Correcto! 😃", Toast.LENGTH_SHORT).show()
        }

        // Evento para botón FALSE
        btnFalse.setOnClickListener {
            Toast.makeText(this, "Incorrecto ❌", Toast.LENGTH_SHORT).show()
        }
    }
}

