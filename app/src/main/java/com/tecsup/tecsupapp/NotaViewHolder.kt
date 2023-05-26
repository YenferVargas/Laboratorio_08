package com.tecsup.tecsupapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NotaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_nota, parent, false)) {

    private var textFecha: TextView? = null
    private var textTitulo: TextView? = null
    private var textContenido: TextView? = null
    private var imgLibro: ImageView? = null

    init {
        textFecha = itemView.findViewById(R.id.textFecha)
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textContenido = itemView.findViewById(R.id.textContenido)
        imgLibro = itemView.findViewById(R.id.imgLibro)
    }

    fun bind(nota: Nota) {
        textFecha?.text = nota.fecha
        textTitulo?.text = nota.titulo
        textContenido?.text = nota.contenido
        imgLibro?.setImageResource(nota.imagen)


    }

}