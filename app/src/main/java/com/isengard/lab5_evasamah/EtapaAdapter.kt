package com.isengard.lab5_evasamah

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class EtapaAdapter (
    private val context: Context,
    private val listaEtapas: List<Etapa>
) : BaseAdapter() {

    override fun getCount(): Int = listaEtapas.size
    override fun getItem(position: Int): Any = listaEtapas[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.activity_etapa, parent, false)

        val etapa = listaEtapas[position]

        val ivEtapa = view.findViewById<ImageView>(R.id.terriMordor)
        val tvNombre = view.findViewById<TextView>(R.id.textLocal1)
        val tvPeligrosidad = view.findViewById<TextView>(R.id.textPeli1)

        tvNombre.text = etapa.nombre
        tvPeligrosidad.text = "Peligrosidad: ${etapa.peligrosidad}"
        ivEtapa.setImageResource(etapa.minTerri)

        return view
    }
}
