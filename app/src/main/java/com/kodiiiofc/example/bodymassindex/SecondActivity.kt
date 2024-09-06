package com.kodiiiofc.example.bodymassindex

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var ibmTV: TextView
    private lateinit var recTV: TextView
    private lateinit var imageIV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ibmTV = findViewById(R.id.tv_ibm)
        imageIV = findViewById(R.id.iv_image)
        recTV = findViewById(R.id.tv_rec)

        val resultString = intent.getStringExtra("result")!!
        val resultDouble = resultString.toDouble()

        ibmTV.setText(Html.fromHtml(ibmTV.text.toString() + " <b>$resultString</b>",Html.FROM_HTML_MODE_COMPACT))

        val resourcesPair = getImageAndRecResouces(resultDouble)

        imageIV.setImageResource(resourcesPair.first)

        recTV.setText(resourcesPair.second)
    }

    private fun getImageAndRecResouces(ibm: Double) : Pair<Int, Int> {
        return when (ibm) {
            in 0.0..<18.5 -> Pair(R.drawable.index18, R.string.rec_index18)
            in 18.5..<24.9 -> Pair(R.drawable.index18_24, R.string.rec_index18_24)
            in 25.0..<29.9 -> Pair(R.drawable.index25_29, R.string.rec_index25_29)
            in 30.0..<34.9 -> Pair(R.drawable.index30_34, R.string.rec_index30_34)
            in 35.0..<39.9 -> Pair(R.drawable.index35_39, R.string.rec_index35_39)
            else -> Pair(R.drawable.index40, R.string.rec_index40)
        }

    }

}