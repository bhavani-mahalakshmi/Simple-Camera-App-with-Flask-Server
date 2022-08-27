package com.example.cse535_assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class SelectCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_category)

        // Create an ArrayAdapter using the string array and a default spinner layout
        val spinner: Spinner = findViewById(R.id.categorySpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.category_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun saveImage(view: android.view.View) {
        val spinner: Spinner = findViewById(R.id.categorySpinner)
        val selectedCategory: String = spinner.getSelectedItem().toString()

    }

}