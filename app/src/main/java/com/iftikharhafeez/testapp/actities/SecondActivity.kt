package com.iftikharhafeez.testapp.actities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iftikharhafeez.testapp.Constants
import com.iftikharhafeez.testapp.R
import com.iftikharhafeez.testapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG : String= SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras

        val msg = bundle?.getString(Constants.USER_MSG_KEY)
        showToast(msg)
        TextUserMessage.text = msg
    }
}