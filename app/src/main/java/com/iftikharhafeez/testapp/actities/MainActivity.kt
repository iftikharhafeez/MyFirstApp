package com.iftikharhafeez.testapp.actities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.iftikharhafeez.testapp.Constants
import com.iftikharhafeez.testapp.R
import com.iftikharhafeez.testapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG : String= MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSHowToast.setOnClickListener {
            Log.i(TAG, "Button was Clicked")
            showToast("Button was clicked!!")
        }

        btnSendMtoNActivity.setOnClickListener {
            val message: String = UserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)
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