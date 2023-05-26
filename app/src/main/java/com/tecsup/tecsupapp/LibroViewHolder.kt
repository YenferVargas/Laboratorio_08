package com.tecsup.tecsupapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LibroViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_libro, parent, false)) {
    private var textTitulo: TextView? = null
    private var textDescripcion: TextView? = null
    private var imgLibro: ImageView? = null

    init {
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textDescripcion = itemView.findViewById(R.id.textDescripcion)
        imgLibro = itemView.findViewById(R.id.imgLibro)
    }

    fun bind(libro: Libro) {

        textTitulo?.text = libro.titulo
        textDescripcion?.text =  libro.descripcion
        imgLibro?.setImageResource(libro.imagen)


    }

}