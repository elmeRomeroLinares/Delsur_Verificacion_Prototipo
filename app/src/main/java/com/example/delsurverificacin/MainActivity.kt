package com.example.delsurverificacin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre_de_cliente_edit_text.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Log.d("Main Activity", "lose of focus")
                hideSoftKeyboard(v)
            }
        }

    }

    fun hideSoftKeyboard(view: View?) {
        view?.apply {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
