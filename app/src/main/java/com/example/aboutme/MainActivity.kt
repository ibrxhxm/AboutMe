package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etNickname: EditText
    private lateinit var btnDone: Button
    private lateinit var tvNickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_bio).movementMethod = ScrollingMovementMethod()

        tvNickname = findViewById<TextView>(R.id.tv_nickname)

        tvNickname.setOnClickListener {
            it.visibility = View.GONE
            val tvValue = it as TextView
            etNickname.setText(tvValue.text.toString())
            etNickname.visibility = View.VISIBLE
            btnDone.visibility = View.VISIBLE
        }

        handleButtonTaps()
    }


    private fun handleButtonTaps() {
        btnDone = findViewById<Button>(R.id.btn_done)
        btnDone.setOnClickListener {
            fun addNickname(view: View) {
                etNickname = findViewById<EditText>(R.id.et_nickname)

                tvNickname.text = etNickname.text.toString()
                etNickname.visibility = View.GONE
                view.visibility = View.GONE
                tvNickname.visibility = View.VISIBLE

                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
            addNickname(it)

        }
    }
}