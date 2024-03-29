package com.example.delsurverificacin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

const val TARIFA_SELECT_DIALOG_FRAGMENT = "tarifa_dialog_fragment"
const val MARCA_MEDIDOR_DIALOG_FRAGMENT = "marca_medidor_dialog_fragment"
const val CURRENT_MARCA_MEDIDOR = "marca_seleccionada"
const val MODELO_MEDIDOR_DIALOG_FRAGMENT = "modelo_medidor_dialog_fragment"
const val FRAGMENT_KEY = "fragment_key"

class MainActivity : AppCompatActivity(),
    TarifaSelectedInterface,
    MarcaMedidorSelectedInterface,
    ModeloMedidorSelectedInterface,
    OnInternaRecyclerViewItemClick,
    OnExternaRecyclerViewItemClick{

    private val dialogFragment = SelectionDialogFragment(
        this,
        this,
        this)
    private val keysForDialogFragmentBundle = Bundle()
    lateinit var tarifaCurrentSelection: String
    lateinit var marcaMedidorCurrentSelection: String
    lateinit var modeloMedidorCurrentSelection: String
    val irregularidadExternaCurrentSelection = mutableListOf<String>()
    val irregularidadInternaCurrentSelections = mutableListOf<String>()
    lateinit var tarifaSelectedTV: TextView
    lateinit var marcaMedidorTV: TextView
    lateinit var modeloMedidorTV: TextView
    lateinit var externaRecyclerViewAdapter: TipificacionExternaRecyclerViewAdapter
    lateinit var internaRecyclerViewAdapter: TipificacionInternaRecyclerViewAdapter
    val dataForExternaRecyclerView = Repository().getIrregularidadesExternasStringList()
    val dataForInternaRecyclerView = Repository().getIrregularidadInternaStringList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlideApp.with(this).load(R.mipmap.ic_launcher).into(logo_delsur_IV)

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

        modelo_medidor_selection_button.setOnClickListener {
            keysForDialogFragmentBundle.putString(FRAGMENT_KEY, MODELO_MEDIDOR_DIALOG_FRAGMENT)
            keysForDialogFragmentBundle.putString(CURRENT_MARCA_MEDIDOR, marcaMedidorCurrentSelection)
            dialogFragment.arguments = keysForDialogFragmentBundle
            dialogFragment.show(supportFragmentManager, MODELO_MEDIDOR_DIALOG_FRAGMENT)
        }

        tarifaSelectedTV = tarifa_selected_TV
        marcaMedidorTV = marca_medidor_TV
        modeloMedidorTV = modelo_medidor_TV

        initIrregularidadExternaRecyclerView(irregularidad_externa_recycler_view)

        initIrregularidadInternaRecyclerView(irregularidad_interna_recycler_view)
    }

    fun initIrregularidadExternaRecyclerView(tipificacionExternaRV: RecyclerView) {
        externaRecyclerViewAdapter = TipificacionExternaRecyclerViewAdapter(this)
        externaRecyclerViewAdapter.actualizarRecyclerAdapter(
            irregularidadExternaCurrentSelection.toList(),
            dataForExternaRecyclerView)

        tipificacionExternaRV.layoutManager =
            GridLayoutManager(this, 3)

        tipificacionExternaRV.adapter = externaRecyclerViewAdapter
    }

    fun initIrregularidadInternaRecyclerView(tipificacionInternaRV: RecyclerView) {
        internaRecyclerViewAdapter = TipificacionInternaRecyclerViewAdapter(this)
        internaRecyclerViewAdapter.actualizarRecyclerAdapter(
            irregularidadInternaCurrentSelections.toList(),
            dataForInternaRecyclerView)

        tipificacionInternaRV.layoutManager =
            GridLayoutManager(this, 3)

        tipificacionInternaRV.adapter = internaRecyclerViewAdapter
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

    override fun modeloMedidorSelectedInterface(modeloMedidorSelected: String){
        modeloMedidorCurrentSelection = modeloMedidorSelected
        modeloMedidorTV.text = modeloMedidorCurrentSelection
        modeloMedidorTV.visibility = View.VISIBLE
    }

    override fun onInternaSelectedItemClick(optionSelected: String) {
        if (irregularidadInternaCurrentSelections.contains(optionSelected)){
            irregularidadInternaCurrentSelections.remove(optionSelected)
        } else {
            irregularidadInternaCurrentSelections.add(optionSelected)
        }

        internaRecyclerViewAdapter.actualizarRecyclerAdapter(irregularidadInternaCurrentSelections.toList(),
            dataForInternaRecyclerView)
    }

    override fun onExternaSelectedItemClick(optionSelected: String) {
        if (irregularidadExternaCurrentSelection.contains(optionSelected)) {
            irregularidadExternaCurrentSelection.remove(optionSelected)
        } else {
            irregularidadExternaCurrentSelection.add(optionSelected)
        }

        externaRecyclerViewAdapter.actualizarRecyclerAdapter(irregularidadExternaCurrentSelection.toList(),
            dataForExternaRecyclerView)
    }
}
