package com.example.delsurverificacin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class TipificacionInternaRecyclerViewAdapter(
    private val itemInternaClickListener: OnInternaRecyclerViewItemClick
) : RecyclerView.Adapter<InternaRadioButtonViewHolder>() {

    lateinit var dataForRecycler: List<String>

    lateinit var ultimasTarifasSeleccionadas: List<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternaRadioButtonViewHolder {
        return InternaRadioButtonViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_seleccion_tarifa_rv, parent, false)
        )
    }

    override fun getItemCount() = dataForRecycler.size

    override fun onBindViewHolder(holder: InternaRadioButtonViewHolder, position: Int) {
        holder.individualRadioButton.text = dataForRecycler[position]
        holder.individualRadioButton.isChecked =
            (ultimasTarifasSeleccionadas.contains(dataForRecycler[position]))

        holder.bindData(itemInternaClickListener, dataForRecycler[position])
    }

    fun actualizarRecyclerAdapter(tipificacionInternaSeleccionada: List<String>, data: List<String>) {
        ultimasTarifasSeleccionadas = tipificacionInternaSeleccionada
        dataForRecycler = data
        notifyDataSetChanged()
    }


}

class InternaRadioButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val individualRadioButton: RadioButton =
        itemView.findViewById(R.id.tarifaRadioButton) as RadioButton

    lateinit var listener: OnInternaRecyclerViewItemClick
    lateinit var tarifaSeleccionada: String

    init {
        individualRadioButton.setOnClickListener {
            listener.onInternaSelectedItemClick(tarifaSeleccionada)
        }
    }

    fun bindData(tarifaItemClick: OnInternaRecyclerViewItemClick, tarifa: String) {
        listener = tarifaItemClick
        tarifaSeleccionada = tarifa
    }
}

interface OnInternaRecyclerViewItemClick {
    fun onInternaSelectedItemClick(optionSelected: String)
}