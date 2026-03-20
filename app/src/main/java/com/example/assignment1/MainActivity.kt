package com.example.assignment1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtTimeOfDay : EditText
    lateinit var txtOutputA : TextView
    lateinit var btnClearA : Button
    lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtTimeOfDay = findViewById(R.id.txtTime)
        txtOutputA = findViewById(R.id.txtOutput)
        btnClearA = findViewById(R.id.btnClear)
        btnSubmit = findViewById(R.id.btnDisplay)
        val mainlayout = findViewById<ConstraintLayout>(R.id.main)
        txtOutputA.text = ""
        txtTimeOfDay.text.clear()

        btnClearA.setOnClickListener{
            txtOutputA.text = ""
            txtTimeOfDay.text.clear()
        }

        btnSubmit.setOnClickListener {
            val timeOfDay =txtTimeOfDay.text.toString()

            if (timeOfDay == "Morning") {
                    txtOutputA.text = "Send someone close to you a Good Morning text"
                    mainlayout.setBackgroundColor(Color.YELLOW)
            }
            else if (timeOfDay == "Mid Morning") {
                txtOutputA.text = "Talk to a colleague"
                mainlayout.setBackgroundColor(Color.LTGRAY)
            }
            else if (timeOfDay == "Afternoon") {
                txtOutputA.text = "Share a funny moment with a friend"
                mainlayout.setBackgroundColor(Color.GREEN)
            }
            else if (timeOfDay == "Afternoon Snack") {
                txtOutputA.text = "Message with a friend or family member"
                mainlayout.setBackgroundColor(Color.BLUE)
            }
            else if (timeOfDay == "Dinner") {
                txtOutputA.text = "Call a friend"
                mainlayout.setBackgroundColor(Color.DKGRAY)
            }
            else if (timeOfDay == "After Dinner" || timeOfDay == "Night") {
                txtOutputA.text = "Watch video's that your friends posted or shared"
                mainlayout.setBackgroundColor(Color.TRANSPARENT)
            }
            else {
                txtOutputA.text = "Invalid time of day inputted"
                mainlayout.setBackgroundColor(Color.RED)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}