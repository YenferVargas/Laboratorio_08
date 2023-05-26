package com.tecsup.tecsupapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contactos.*

class ContactosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        title = "Contactos de Emergencia"

        val contactosList = arrayOf("Tópico Tecsup", "Vigilancia", "Enfermería", "Área Académica", "Desarrollo Docente")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactosList)
        listContactos.adapter = adapter

        registerForContextMenu(listContactos)

        floatinMensaje.setOnClickListener {
            showPopup(it)
        }

    }

    // 1. Menu de Opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemConfiguracion -> {
                Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show()
            }
            R.id.itemActualizar -> {
                Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    // 2. Menu Contextual
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemConfiguracion -> {
                Toast.makeText(this, "Contextual - Configuracion", Toast.LENGTH_SHORT).show()
            }
            R.id.itemActualizar -> {
                Toast.makeText(this, "Contextual - Actualizar", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    // 3. Menu Flotante
    private fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_wp, popup.menu)
        popup.show()
    }

}







