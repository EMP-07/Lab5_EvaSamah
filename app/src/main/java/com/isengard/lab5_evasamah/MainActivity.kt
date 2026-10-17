package com.isengard.lab5_evasamah

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listEtapas: List<Etapa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lvEtapas = findViewById<ListView>(R.id.listaEtapas)

        listEtapas = listOf(
            Etapa("La Comarca", "Baja", android.R.drawable.ic_menu_myplaces),
            Etapa("Rivendell", "Baja", android.R.drawable.ic_menu_gallery),
            Etapa("Minas de Moria", "Alta", android.R.drawable.ic_menu_compass),
            Etapa("Lothlórien", "Media", android.R.drawable.ic_menu_manage),
            Etapa("Mordor", "Extrema", android.R.drawable.ic_menu_mapmode)
        )

        lvEtapas.adapter = EtapaAdapter(this, listEtapas)
        registerForContextMenu(lvEtapas)
    }

    // Menu de opciones (barra de arriba)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnAbandonar -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Menu contextual (mantener pulsado)
    override fun onCreateContextMenu(
        menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Acciones de Campaña")
        menuInflater.inflate(R.menu.menu_etapas, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val etapa = listEtapas[info.position]

        return when (item.itemId) {
            R.id.btnInspeccionar -> {
                val intent = Intent(this, DetalleActivity::class.java).apply {
                    putExtra("EXTRA_NOMBRE", etapa.nombre)
                    putExtra("EXTRA_PELIGRO", etapa.peligrosidad)
                }
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}