package com.example.eatup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Inisialisasi tampilan
        val imageView: ImageView = findViewById(R.id.imageberita)
        val titleTextView: TextView = findViewById(R.id.textView)
        val tanggalTextView: TextView = findViewById(R.id.tanggal)
        val descTextView: TextView = findViewById(R.id.textDetail)

        // Mendapatkan data dari intent
        val photo = intent.getIntExtra("photo", 0)
        val title = intent.getStringExtra("title")
        val tanggal = intent.getStringExtra("date")
        val desc = intent.getStringExtra("desc")

        // Mengatur data ke tampilan
        imageView.setImageResource(photo)
        titleTextView.text = title
        tanggalTextView.text = tanggal
        descTextView.text = desc
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Go back to the previous screen
        return true
    }
}