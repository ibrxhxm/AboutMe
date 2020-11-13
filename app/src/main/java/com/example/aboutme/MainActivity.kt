package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleButtonTaps()
    }

    private fun handleButtonTaps() {
        findViewById<Button>(R.id.btn_done).setOnClickListener {
            fun addNickname(view: View) {
                val etNickname = findViewById<EditText>(R.id.et_nickname)
                val tvNickname = findViewById<TextView>(R.id.tv_nickname)

                tvNickname.text = etNickname.text.toString()
                etNickname.visibility = View.GONE
                view.visibility = View.GONE

                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
            addNickname(it)

        }
    }
}