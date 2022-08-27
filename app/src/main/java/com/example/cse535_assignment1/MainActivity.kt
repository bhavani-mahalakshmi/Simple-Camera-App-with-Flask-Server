package com.example.cse535_assignment1

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

private const val REQUEST_CODE = 42
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonClick = findViewById<Button>(R.id.btnSelectCategory)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SelectCategory::class.java)
            startActivity(intent)
        }
    }

    fun takePic(view: android.view.View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        startActivityForResult(intent, REQUEST_CODE)
//        if(intent.resolveActivity(packageManager) != null){
//            startActivityForResult(intent, REQUEST_CODE)
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            val takenImage = data?.extras?.get("data") as Bitmap
            val imageView: ImageView = findViewById(R.id.imageView)
            imageView.setImageBitmap(takenImage)
            val btnSelectCategory: Button = findViewById(R.id.btnSelectCategory)
            btnSelectCategory.setEnabled(true);
        }
    }

    fun saveImage(view: android.view.View) {}
}