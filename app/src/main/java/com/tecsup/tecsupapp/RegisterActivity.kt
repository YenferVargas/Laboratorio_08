package com.tecsup.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        title = "Registro de usuarios"
    }

}