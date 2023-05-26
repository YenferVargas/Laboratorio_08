package com.tecsup.tecsupapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LibroAdapter(val list: List<Libro>): RecyclerView.Adapter<LibroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LibroViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro: Libro = list[position]
        holder.bind(libro)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}