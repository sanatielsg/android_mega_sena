package br.com.sanatiel.megasena

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val TAG: String = "logs"
    private lateinit var btnGenerate: Button
    private lateinit var edtNumber: EditText
    private lateinit var txtResult : TextView
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenerate = findViewById(R.id.btn_generate)
        edtNumber = findViewById(R.id.edt_number)
        txtResult = findViewById(R.id.txt_result)

        prefs = getSharedPreferences("shdb", Context.MODE_PRIVATE)

        val oldResult = prefs.getString("result",null)

        oldResult?.let {
            txtResult.text = oldResult
        }

        btnGenerate.setOnClickListener {
            generateNumbers(edtNumber.text.toString(), txtResult)
        }
    }

    fun generateNumbers(inputNumber: String, textView: TextView){
        if(inputNumber.isEmpty()){
            Toast.makeText(this, getString(R.string.message_range_number), Toast.LENGTH_SHORT).show()
            return
        }
        val qtyNumbers = inputNumber.toInt()

        if (qtyNumbers < 6|| qtyNumbers > 15){
            Toast.makeText(this, getString(R.string.message_range_number), Toast.LENGTH_SHORT).show()
            return
        }

        val random = Random()
        val numbers = mutableSetOf<Int>()

        while (true){
            val number = random.nextInt(60)
            numbers.add(number + 1)
            if (numbers.size == qtyNumbers) break
        }
        textView.text = numbers.joinToString("-")

        prefs.edit().apply {
            putString("result",textView.text.toString())
            apply()
        }
    }
}