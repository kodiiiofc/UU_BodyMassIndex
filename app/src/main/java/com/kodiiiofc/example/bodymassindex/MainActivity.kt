package com.kodiiiofc.example.bodymassindex

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var heightET: EditText
    private lateinit var massET: EditText
    private lateinit var calculateIbmBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        heightET = findViewById(R.id.et_height)
        massET = findViewById(R.id.et_mass)
        calculateIbmBTN = findViewById(R.id.btn_calculate_ibm)

        calculateIbmBTN.setOnClickListener {
            val height = textToDouble(heightET)
            val mass = textToDouble(massET)

            var flag = true

            if (height == Double.NaN || height > 250.0 || height < 140) {
                heightET.setText("")
                heightET.hint = "Введите корректный рост в см."
                heightET.setHintTextColor(Color.RED)
                flag = false
            }

            if (mass == Double.NaN || mass < 45 || mass > 650) {
                massET.setText("")
                massET.hint = "Введите корректную массу в кг."
                massET.setHintTextColor(Color.RED)
                flag = false
            }

            if (flag) {
                val result = String.format(
                    "%.3f",
                    mass / (height / 100 * height / 100)
                )

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("result", result)
                startActivity(intent)

            }

        }

    }

    fun textToDouble(view: TextView): Double {
        try {
            return view.text.toString().toDouble()
        } catch (e: Exception) {
            return Double.NaN
        }
    }

}


