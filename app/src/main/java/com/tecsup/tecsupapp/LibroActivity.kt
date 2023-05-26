package com.tecsup.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notas.*

class LibroActivity: AppCompatActivity(){
    private val listLibros = listOf(
        Libro("Odisea - Homero", "«Mientras los maderos estan sujetos \n por las clavijas, seguiré aquiy sufiré \n los males que haya de padecer, y \n luego que las olas deshagan la bals...",  R.drawable.portada1p),
        Libro("Don Quijote de la Mancha,...", "«El amor junta los cetros con los \n" +
                "cayados; la grandeza con la bajeza;\n" +
                "hace posible lo imposible; iguala 1\n" +
                "diferentes estados y viene a ser pod...",  R.drawable.portada2p ),
        Libro("El Principito, de Antonie de...", "«He aqui mi secreto. Es muy simple: \n" +
                "0 se ve bien sino con el corazon. Lo\n" +
                "esencial es invisible los ojos».",  R.drawable.portada3p),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)
        title = "Librería"

        recyclerNote.apply {
            // layoutManager = LinearLayoutManager(context)
            // layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = LibroAdapter(listLibros)
        }
    }
}