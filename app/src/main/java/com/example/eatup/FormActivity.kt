package com.example.eatup;
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.eatup.R

class FormActivity : AppCompatActivity() {
    private lateinit var mainLayout: RelativeLayout
    private lateinit var editText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)
        // Lakukan inisialisasi dan tindakan lainnya di sini
        mainLayout = findViewById(R.id.relatiflayout)
        editText = findViewById(R.id.isiJudulBerita)

        mainLayout.setOnClickListener {
            editText.clearFocus()
        }
    }
}



