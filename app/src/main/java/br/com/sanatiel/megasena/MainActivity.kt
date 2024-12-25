package br.com.sanatiel.megasena

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG: String = "logs"
    lateinit var btnGenerate: Button
    lateinit var edtNumber: EditText
    lateinit var txtResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenerate = findViewById(R.id.btn_generate)
        edtNumber = findViewById(R.id.edt_number)
        txtResult = findViewById(R.id.txt_result)

        btnGenerate.setOnClickListener {
            generateNumbers()
        }
    }

    fun generateNumbers(){
        txtResult.text = "Ok"
    }
}