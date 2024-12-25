package br.com.sanatiel.megasena

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
            if(edtNumber.text.isNotEmpty()){
                val qtyNumbers = edtNumber.text.toString().toInt()
                if (qtyNumbers in 6..15){
                    val random = Random()
                    val numbers = mutableSetOf<Int>()

                    while (true){
                        val number = random.nextInt(60)
                        numbers.add(number + 1)
                        if (numbers.size == qtyNumbers) break
                    }

                    numbers.forEach(){num->
                        Log.i(TAG, num.toString())
                    }
                    txtResult.text = numbers.joinToString("-")

                }else{
                    Toast.makeText(this, getString(R.string.message_range_number), Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, getString(R.string.message_range_number), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun generateNumbers(number: Int, textView: TextView){

    }
}