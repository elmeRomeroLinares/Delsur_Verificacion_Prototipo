package com.example.delsurverificacin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class TipificacionExternaRecyclerViewAdapter(
    private val itemExternaClickListener: OnExternaRecyclerViewItemClick
) : RecyclerView.Adapter<ExternaRadioButtonViewHolder>() {

    lateinit var dataForRecycler: List<String>

    lateinit var ultimasTipificacionesExternasSeleccionadas: List<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExternaRadioButtonViewHolder {
        return ExternaRadioButtonViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_seleccion_tarifa_rv, parent, false)
        )
    }

    override fun getItemCount() = dataForRecycler.size

    override fun onBindViewHolder(holder: ExternaRadioButtonViewHolder, position: Int) {
        holder.individualRadioButton.text = dataForRecycler[position]
        holder.individualRadioButton.isChecked =
            (ultimasTipificacionesExternasSeleccionadas.contains(dataForRecycler[position]))

        holder.bindData(itemExternaClickListener, dataForRecycler[position])
    }

    fun actualizarRecyclerAdapter(tipificacionExternaSeleccionada: List<String>, data: List<String>) {
        ultimasTipificacionesExternasSeleccionadas = tipificacionExternaSeleccionada
        dataForRecycler = data
        notifyDataSetChanged()
    }


}

class ExternaRadioButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val individualRadioButton: RadioButton =
        itemView.findViewById(R.id.tarifaRadioButton) as RadioButton

    lateinit var listener: OnExternaRecyclerViewItemClick
    lateinit var tarifaSeleccionada: String

    init {
        individualRadioButton.setOnClickListener {
            listener.onExternaSelectedItemClick(tarifaSeleccionada)
        }
    }

    fun bindData(tarifaItemClick: OnExternaRecyclerViewItemClick, tarifa: String) {
        listener = tarifaItemClick
        tarifaSeleccionada = tarifa
    }
}

interface OnExternaRecyclerViewItemClick {
    fun onExternaSelectedItemClick(optionSelected: String)
}