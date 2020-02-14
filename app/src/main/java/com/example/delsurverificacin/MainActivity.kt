package com.example.delsurverificacin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val TARIFA_SELECT_DIALOG_FRAGMENT = "tarifa_dialog_fragment"
const val MARCA_MEDIDOR_DIALOG_FRAGMENT = "marca_medidor_dialog_fragment"
const val MODELO_MEDIDOR_DIALOG_FRAGMENT = "modelo_medidor_dialog_fragment"
const val FRAGMENT_KEY = "fragment_key"

class MainActivity : AppCompatActivity(),
    TarifaSelectedInterface,
    MarcaMedidorSelectedInterface {

    private val dialogFragment = SelectionDialogFragment(this, this)
    private val keysForDialogFragmentBundle = Bundle()
    lateinit var tarifaCurrentSelection: String
    lateinit var marcaMedidorCurrentSelection: String
    lateinit var tarifaSelectedTV: TextView
    lateinit var marcaMedidorTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre_de_cliente_edit_text.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Log.d("Main Activity", "lose of focus")
                hideSoftKeyboard(v)
            }
        }

        tarifa_selection_button.setOnClickListener {
            keysForDialogFragmentBundle.putString(FRAGMENT_KEY, TARIFA_SELECT_DIALOG_FRAGMENT)
            dialogFragment.arguments = keysForDialogFragmentBundle
            dialogFragment.show(supportFragmentManager, TARIFA_SELECT_DIALOG_FRAGMENT)
        }

        marca_medidor_selection_button.setOnClickListener {
            keysForDialogFragmentBundle.putString(FRAGMENT_KEY, MARCA_MEDIDOR_DIALOG_FRAGMENT)
            dialogFragment.arguments = keysForDialogFragmentBundle
            dialogFragment.show(supportFragmentManager, MARCA_MEDIDOR_DIALOG_FRAGMENT)
        }

        tarifaSelectedTV = tarifa_selected_TV
        marcaMedidorTV = marca_medidor_TV
    }

    fun hideSoftKeyboard(view: View?) {
        view?.apply {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun tarifaSelectedInterface(tarifaSelected: String) {
        tarifaCurrentSelection = tarifaSelected
        tarifaSelectedTV.text = tarifaCurrentSelection
        tarifaSelectedTV.visibility = View.VISIBLE
    }

    override fun marcaMedidorSelectedInterface(marcaMedidorSelected: String) {
        marcaMedidorCurrentSelection = marcaMedidorSelected
        marcaMedidorTV.text = marcaMedidorCurrentSelection
        marcaMedidorTV.visibility = View.VISIBLE
    }
}
