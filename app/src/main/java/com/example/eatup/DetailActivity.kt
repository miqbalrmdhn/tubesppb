package com.example.eatup;
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface


import android.app.Activity
import android.content.Intent


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.eatup.R
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    private lateinit var content: BeritaModel.News
    val adapter = BeritaAdapter(BeritaModel.newsList)
    private fun deleteContent() {
        val position = intent.getIntExtra("position", -1)
        if (position != -1 && position < BeritaModel.newsList.size) {
            BeritaModel.removeNews(position)
            setResult(Activity.RESULT_OK, intent)
        } else {
            // Handle invalid position
            setResult(Activity.RESULT_CANCELED, intent)
        }
        adapter.notifyDataSetChanged()
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        startActivity(intent)
        finish() // Menutup FormActivity agar tidak bisa kembali menggunakan tombol "back"
    }




    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val adapter = BeritaAdapter(BeritaModel.newsList)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Inisialisasi tampilan
        val imageView: ImageView = findViewById(R.id.imageberita)
        val titleTextView: TextView = findViewById(R.id.textView)
        val descTextView: TextView = findViewById(R.id.textDetail)
        val tanggalTextView: TextView = findViewById(R.id.tanggal)
        val deleteButton: Button = findViewById(R.id.delete)

        // Mendapatkan data dari intent
        val photo = intent.getIntExtra("photo", 0)
        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val desc = intent.getStringExtra("desc")

        // Mengatur data ke tampilan
        imageView.setImageResource(photo)
        titleTextView.text = title
        tanggalTextView.text = date
        descTextView.text = desc

        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val parsedDate = dateFormat.parse(date)
        val delete: Button = findViewById(R.id.delete)
        deleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi")
            builder.setMessage("Apakah Anda yakin ingin menghapus berita ini?")

            builder.setPositiveButton("Ya") { _, _ ->
                deleteContent()
            }

            builder.setNegativeButton("Tidak", null)

            val dialog = builder.create()
            dialog.show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Go back to the previous screen
        return true
    }
}
