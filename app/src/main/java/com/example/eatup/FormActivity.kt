package com.example.eatup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class FormActivity : AppCompatActivity() {
    private lateinit var editTextJudul: EditText
    private lateinit var editTextDeskripsi: EditText
    private lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)

        val adapter = BeritaAdapter(BeritaModel.newsList)

        editTextJudul = findViewById(R.id.editTextJudulBerita)
        editTextDeskripsi = findViewById(R.id.editTextDeskripsi)
        datePicker = findViewById(R.id.datePicker)

        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            // Ambil nilai dari EditText
            val judulBerita = editTextJudul.text.toString()
            val deskripsiBerita = editTextDeskripsi.text.toString()
            val tanggalBerita = getSelectedDate(datePicker)

            // Simpan data ke database
            val newNews = BeritaModel.News(
                judulBerita,
                deskripsiBerita,
                R.drawable.logo_up,
                tanggalBerita
            )
            BeritaModel.addNews(newNews)

            // Memperbarui tampilan RecyclerView dengan berita baru
            adapter.notifyDataSetChanged()

            // Kembali ke MainActivity
            val intent = Intent(this@FormActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup FormActivity agar tidak bisa kembali menggunakan tombol "back"
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getSelectedDate(datePicker: DatePicker): Date {
        val year = datePicker.year
        val month = datePicker.month
        val dayOfMonth = datePicker.dayOfMonth

        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        return calendar.time
    }
}
