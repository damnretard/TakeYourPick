package com.example.takeyourpick

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val bgg = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.bgg)
        button1.text = "${(1..1000).random()}"
        button2.text = "${(1..1000).random()}"

        button1.setOnClickListener {

            val leftNum = button1.text.toString().toInt()
            val rightNum = button2.text.toString().toInt()
            if (leftNum > rightNum){
                bgg.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                bgg.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
            }
            button1.text = "${(1..1000).random()}"
            button2.text = "${(1..1000).random()}"
        }
        button2.setOnClickListener {
            val leftNum = button1.text.toString().toInt()
            val rightNum = button2.text.toString().toInt()
            if (leftNum < rightNum){
                bgg.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                bgg.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
            }
            button1.text = "${(1..1000).random()}"
            button2.text = "${(1..1000).random()}"
        }



    }
}