package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val actionBar = supportActionBar
        actionBar?.hide()

        imgProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("name","Jose Diaz")
            intent.putExtra("email", "jose@gmail.com")
            startActivity(intent)
        }

        btnContactoTecsup.setOnClickListener {
            startActivity(Intent(this, ContactosActivity::class.java))
        }

        configurationNavigationDrawer()

    }

    private fun configurationNavigationDrawer() {
        navView.setNavigationItemSelectedListener { menuItem ->

            drawerLayout.closeDrawer(GravityCompat.START)

            when(menuItem.itemId) {
                R.id.itemBuscar -> {
                    Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.itemActualizar -> {
                    Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }

        }
    }

}








