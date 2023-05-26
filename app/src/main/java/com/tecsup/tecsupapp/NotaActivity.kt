package com.tecsup.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_notas.*

class NotaActivity : AppCompatActivity() {

    private val listNotas = listOf(
        Nota("20/10/2022 - 15:00", "Primera nota", "Descripción de nota",  R.drawable.portada1),
        Nota("20/11/2022 - 10:00", "Segunda nota", "Descripción de nota", R.drawable.portada2 ),
        Nota("20/09/2022 - 12:00", "Tercera nota", "Descripción de nota", R.drawable.portada3),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        recyclerNote.apply {
           // layoutManager = LinearLayoutManager(context)
            // layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = NotaAdapter(listNotas)
        }
    }

}