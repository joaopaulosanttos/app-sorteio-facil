package com.example.sorteiofacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextFieldNumbers: EditText = findViewById(R.id.edit_field_numbers)
        val textViewResult: TextView = findViewById(R.id.text_view_result)
        val buttonGenerate: Button = findViewById(R.id.btn_generate)

        buttonGenerate.setOnClickListener {
            val text = editTextFieldNumbers.text.toString()
            generateResult(text, textViewResult)
        }
    }

    private fun generateResult(text: String, textResult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(
                this,
                "Por favor, insira somente números neste campo.",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val qtd = text.toInt()

        if (qtd < 6 || qtd > 15) {
            Toast.makeText(
                this,
                "Por favor, preencha apenas com números entre 6 e 15.",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val listNumers = mutableSetOf<Int>()
        val random = Random

        while (true) {
            val number = random.nextInt(60)
            listNumers.add(number + 1)

            if (listNumers.size == qtd) {
                break
            }
        }

        textResult.text = listNumers.joinToString(" - ")

    }

}

