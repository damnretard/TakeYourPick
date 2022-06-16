package com.example.takeyourpick

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
//Global variables used as flags to use same function for different buttons
var x: Int = 0
var y: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        // called the function to assign random numbers to the two buttons
        assignNumber()

        button1.setOnClickListener {
            x = 1 // flag to indicate that button1 has been pressed
            val leftNum = button1.text.toString().toInt()
            val rightNum = button2.text.toString().toInt()
            // called the function to compare the numbers, change the background color and display toast
            conditionClick(leftNum, rightNum, x)
            // called the function to reassign the numbers
            assignNumber()
            x = 0 // reset the flag

        }

        button2.setOnClickListener {
            y = 2 // flag to indicate that button2 has been pressed
            val leftNum = button1.text.toString().toInt()
            val rightNum = button2.text.toString().toInt()
            // called the function to compare the numbers, change the background color and display toast
            conditionClick(leftNum, rightNum, y)
            // called the function to reassign the numbers
            assignNumber()
            y = 0 // reset the flag

        }

    }
    // function to compare the numbers, change the background color and display toast
    private fun conditionClick(l: Int, r: Int, z: Int) {
        val bgg = findViewById<ConstraintLayout>(R.id.bgg)
        if (r > l && z == 2 || r < l && z == 1) {
            bgg.setBackgroundColor(Color.GREEN)
            Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            bgg.setBackgroundColor(Color.RED)
            Toast.makeText(this@MainActivity, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }
    // function to assign random numbers to the two buttons
    private fun assignNumber() {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        button1.text = "${(1..1000).random()}"
        button2.text = "${(1..1000).random()}"
        if (button1.text == button2.text) // in case the random numbers on both buttons are same then reassign one of them
            button1.text = "${(1..1000).random()}"

    }
}