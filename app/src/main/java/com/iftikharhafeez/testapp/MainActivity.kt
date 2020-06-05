package com.iftikharhafeez.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSHowToast.setOnClickListener {
            Log.i("MainActivity", "Button was Clicked")
            Toast.makeText(this,  "Button was clicked!!", Toast.LENGTH_SHORT).show()
        }

        btnSendMtoNActivity.setOnClickListener {
            val message: String = UserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("User_message", message)
            startActivity(intent) // explicit intent

        }

        ShareBtn.setOnClickListener {

            val message: String = UserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "share to : "))
        }

        btnRecuclerviewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}