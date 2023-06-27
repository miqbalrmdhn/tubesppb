package com.example.eatup
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.eatup.BeritaAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatup.FormActivity
import com.example.eatup.R
import java.util.Calendar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var tvwTitle: TextView
    private lateinit var tvwDesc: TextView
    private lateinit var tvwPhoto: ImageView
    private lateinit var spinner: Spinner
    private lateinit var adapter: BeritaAdapter


    val calendar = Calendar.getInstance()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1 // Perhatikan bahwa bulan dimulai dari 0 (Januari = 0)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    @SuppressLint("MissingInflatedId")

    private fun deleteContent(position: Int) {
        BeritaModel.newsList.removeAt(position)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == BeritaAdapter.DELETE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            val position = data?.getIntExtra("position", -1)
//            if (position != null && position != -1) {
//                adapter.newsList.removeAt(position)
//                adapter.notifyDataSetChanged()
//            }
//        }
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.konten_banyak)
        val layoutManager = LinearLayoutManager(this)
        adapter = BeritaAdapter(BeritaModel.newsList)

        val fabButton: FloatingActionButton = findViewById(R.id.floatingActionButton2)
        fabButton.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
