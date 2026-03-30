package com.example.assignment1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
    lateinit var txt1 : TextView
    lateinit var txt2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtTimeOfDay = findViewById(R.id.txtTime)
        txtOutputA = findViewById(R.id.txtOutput)
        btnClearA = findViewById(R.id.btnClear)
        btnSubmit = findViewById(R.id.btnDisplay)
        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)
        val mainlayout = findViewById<ConstraintLayout>(R.id.main)
        txtOutputA.text = ""
        txtTimeOfDay.text.clear()

        btnClearA.setOnClickListener{
            txtOutputA.text = ""
            txtTimeOfDay.text.clear()
            mainlayout.setBackgroundColor(Color.WHITE)
        }

        btnSubmit.setOnClickListener {
            val timeOfDay =txtTimeOfDay.text.toString()

            if (timeOfDay.isEmpty()) {
             txtOutputA.text = "Error - Please use a value from the following, Morning \n Mid Morning \n Afternoon \n Afternoon Snack \n Dinner \n After Dinner/Night"
            }
           else if (timeOfDay == "Morning") {
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
                txt1.setTextColor(Color.WHITE)
                txt2.setTextColor(Color.WHITE)
                txtTimeOfDay.setTextColor(Color.WHITE)
                txtOutputA.setTextColor(Color.WHITE)
            }
            else if (timeOfDay == "Dinner") {
                txtOutputA.text = "Call a friend"
                mainlayout.setBackgroundColor(Color.DKGRAY)
                txt1.setTextColor(Color.WHITE)
                txt2.setTextColor(Color.WHITE)
                txtTimeOfDay.setTextColor(Color.WHITE)
                txtOutputA.setTextColor(Color.WHITE)
            }
            else if (timeOfDay == "After Dinner" || timeOfDay == "Night") {
                txtOutputA.text = "Watch video's that your friends posted or shared"
                mainlayout.setBackgroundColor(Color.TRANSPARENT)
            }
            else {
                txtOutputA.text = "Error - Please use a value from the following, Morning \n Mid Morning \n Afternoon \n Afternoon Snack \n Dinner \n After Dinner/Night"
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