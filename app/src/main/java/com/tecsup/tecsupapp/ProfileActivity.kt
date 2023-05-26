package com.tecsup.tecsupapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.File

class ProfileActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private var filePhoto: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle = intent.extras
        if (bundle != null) {
            textNombre.text = "${bundle.getString("name")}"
        }

        imgUpdatePhoto.setOnClickListener {
            showPopup(it)
        }
    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_perfil, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.itemTomarFoto -> {
                takePhoto()
                true
            }
            R.id.itemSeleccionarFoto -> {
                galleryPhoto()
                true
            }
            else -> false
        }
    }

    private fun takePhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            // tenemos el permiso de usar la camara
            // podemos abrir la camara
            openCamera()
        } else {
            // no tenemos el permiso y necesitamos solicitarlo
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // el usuario acepto el permiso
            Log.v("Permisos_tecsup", "el usuario otorgo el permiso")
            openCamera()
        } else {
            Log.v("Permisos_tecsup", "el usuario no otorgo el permiso")
        }
    }

    private fun openCamera() {
        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        filePhoto = getPhotoFile("imagen_temporal")
        val provideFile = FileProvider.getUriForFile(this, "com.tecsup.tecsupapp", filePhoto!!)
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, provideFile)
        resultTakeLauncher.launch(takePhotoIntent)
    }

    private fun getPhotoFile(filename: String): File {
        val directoryStorage = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(filename, ".jpg", directoryStorage)
    }

    private var resultTakeLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val takenPhoto = BitmapFactory.decodeFile(filePhoto?.absolutePath)
            imgUpdatePhoto.setImageBitmap(takenPhoto)
        }
    }

    // Abrir Galeria
    private fun galleryPhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
            // tiene permiso activo
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultOpenGallery.launch(gallery)
        } else {
            // debemos solicitar el permiso
            requestPermissionGalleryLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private var requestPermissionGalleryLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted: Boolean ->
        if (isGranted) {
            // el usuario nos dio el permiso
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultOpenGallery.launch(gallery)
        } else {
            // el usuario no nos dio el permiso
        }
    }

    private var resultOpenGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            imgUpdatePhoto.setImageURI(data?.data)
        }
    }

}