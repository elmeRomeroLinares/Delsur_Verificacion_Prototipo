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

class TarifaDialogFragment: DialogFragment(), OnTarifaItemClick {

    companion object {
        lateinit var seleccionActual: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(
            R.layout.seleccion_general_dialog_fragment,
            container,
            false)
        val dialogFragmentCancelButton = rootView.findViewById<Button>(
            R.id.cancelar_dialog_fragment_button)
        val dialogFragmentSelectButton = rootView.findViewById<Button>(
            R.id.seleccionar_dialog_fragment_button)
        val dialogFragmentRecyclerView = rootView.findViewById<RecyclerView>(
            R.id.general_dialog_fragment_recycler_view
        )

        initRecyclerView(dialogFragmentRecyclerView)

        dialogFragmentCancelButton.setOnClickListener {
            dismiss()
        }

        dialogFragmentSelectButton.setOnClickListener {
            // pasar seleccion a actividad.
            seleccionActual.let{
                Log.d("Dialog Fragment", it)
            }
            dismiss()
        }

        return rootView
    }

    fun initRecyclerView(recyclerView: RecyclerView) {
        val data = Repository().getTarifasStringArray()

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = DialogFragmentRecyclerViewAdapter(data, this)
    }

    override fun onTarifaItemClick(tarifaSeleccionada: String) {
        seleccionActual = tarifaSeleccionada
        Log.d("Dialog Fragment", tarifaSeleccionada)
    }

}