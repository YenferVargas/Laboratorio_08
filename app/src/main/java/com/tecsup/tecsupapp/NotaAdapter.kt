package com.tecsup.tecsupapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotaAdapter(val list: List<Nota>) : RecyclerView.Adapter<NotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NotaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota: Nota = list[position]
        holder.bind(nota)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}