package com.example.delsurverificacin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionDialogFragment(
    val tarifaSelectedListener: TarifaSelectedInterface,
    val marcaMedidorSelectedListener: MarcaMedidorSelectedInterface,
    val modeloMedidorSelectedListener: ModeloMedidorSelectedInterface
) : DialogFragment(), OnRecyclerViewItemClick {

    var fragmentInitializerButton: String? = " "
    var marcaCurrentSelection: String? = ""
    private lateinit var data: List<String>
    val dialogFragmentRecyclerViewAdapter =
        DialogFragmentRecyclerViewAdapter(this)

    companion object {
        lateinit var seleccionActual: String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentInitializerButton = arguments?.getString(FRAGMENT_KEY)
        marcaCurrentSelection = arguments?.getString(CURRENT_MARCA_MEDIDOR)


        when(fragmentInitializerButton) {
            TARIFA_SELECT_DIALOG_FRAGMENT -> data = Repository().getTarifasStringList()
            MARCA_MEDIDOR_DIALOG_FRAGMENT -> data = Repository().getMarcaMedidorStringList()
            MODELO_MEDIDOR_DIALOG_FRAGMENT -> {
                // Filtrar con la variable marcaCurrentSelection la siguiente lista
                data = Repository().getModelosMedidores().filter {
                    it.contains(marcaCurrentSelection.toString())
                }
            }
        }

        val rootView: View = inflater.inflate(
            R.layout.seleccion_general_dialog_fragment,
            container,
            false
        )
        val dialogFragmentCancelButton = rootView.findViewById<Button>(
            R.id.cancelar_dialog_fragment_button
        )
        val dialogFragmentSelectButton = rootView.findViewById<Button>(
            R.id.seleccionar_dialog_fragment_button
        )
        val dialogFragmentRecyclerView = rootView.findViewById<RecyclerView>(
            R.id.general_dialog_fragment_recycler_view
        )

        initRecyclerView(dialogFragmentRecyclerView, data)

        dialogFragmentCancelButton.setOnClickListener {
            dismiss()
        }

        dialogFragmentSelectButton.setOnClickListener {
            if (fragmentInitializerButton == TARIFA_SELECT_DIALOG_FRAGMENT) {
                tarifaSelectedListener.tarifaSelectedInterface(seleccionActual)
            } else if (fragmentInitializerButton == MARCA_MEDIDOR_DIALOG_FRAGMENT) {
                marcaMedidorSelectedListener.marcaMedidorSelectedInterface(seleccionActual)
            } else {
                modeloMedidorSelectedListener.modeloMedidorSelectedInterface(seleccionActual)
            }
            dismiss()
        }

        return rootView
    }

    fun initRecyclerView(recyclerView: RecyclerView, dataForRecycler: List<String>) {

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        dialogFragmentRecyclerViewAdapter.actualizarRecyclerAdapter("none" ,data)
        recyclerView.adapter = dialogFragmentRecyclerViewAdapter
    }

    override fun onSelectedItemClick(optionSelected: String) {
        seleccionActual = optionSelected
        dialogFragmentRecyclerViewAdapter.actualizarRecyclerAdapter(seleccionActual,data)
        Log.d("Dialog Fragment", optionSelected)
    }

}

interface TarifaSelectedInterface {
    fun tarifaSelectedInterface(tarifaSelected: String)
}

interface MarcaMedidorSelectedInterface {
    fun marcaMedidorSelectedInterface(marcaMedidorSelected: String)
}

interface ModeloMedidorSelectedInterface {
    fun modeloMedidorSelectedInterface(modeloMedidorSelected: String)
}