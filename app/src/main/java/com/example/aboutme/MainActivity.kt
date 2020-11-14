package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tvBio.movementMethod = ScrollingMovementMethod()

        binding.tvNickname.setOnClickListener {
            it.visibility = View.GONE
            val tvValue = it as TextView
            binding.apply {
                etNickname.setText(tvValue.text.toString())
                invalidateAll()
                etNickname.visibility = View.VISIBLE
                btnDone.visibility = View.VISIBLE
            }
        }

        handleButtonTaps()
    }


    private fun handleButtonTaps() {
        binding.apply {

            btnDone.setOnClickListener {
                fun addNickname(view: View) {
                    tvNickname.text = etNickname.text.toString()
                    invalidateAll()
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
}