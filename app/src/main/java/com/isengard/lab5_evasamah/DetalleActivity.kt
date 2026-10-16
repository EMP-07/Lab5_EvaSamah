package com.isengard.lab5_evasamah

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE") ?: "Desconocido"
        val peligro = intent.getStringExtra("EXTRA_PELIGRO") ?: "Desconocido"

        findViewById<TextView>(R.id.txDetalleNombre).text = nombre
        findViewById<TextView>(R.id.txDetallePeligro).text = "Nivel de peligro: $peligro"
    }
}
