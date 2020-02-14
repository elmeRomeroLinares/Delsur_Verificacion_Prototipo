package com.example.delsurverificacin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class DialogFragmentRecyclerViewAdapter(
    private val tarifaListener: OnRecyclerViewItemClick
) : RecyclerView.Adapter<RadioButtonViewHolder>() {

    lateinit var dataForRecycler: List<String>

    var ultimaTarifaSeleccionada: String = "none"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonViewHolder {
        return RadioButtonViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_seleccion_tarifa_rv, parent, false)
        )
    }

    override fun getItemCount() = dataForRecycler.size

    override fun onBindViewHolder(holder: RadioButtonViewHolder, position: Int) {
        holder.individualRadioButton.text = dataForRecycler[position]
        holder.individualRadioButton.isChecked =
            (ultimaTarifaSeleccionada == dataForRecycler[position])

        holder.bindData(tarifaListener, dataForRecycler[position])
    }

    fun actualizarRecyclerAdapter(tarifaSeleccionada: String, data: List<String>) {
        ultimaTarifaSeleccionada = tarifaSeleccionada
        dataForRecycler = data
        notifyDataSetChanged()
    }


}

class RadioButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val individualRadioButton: RadioButton =
        itemView.findViewById(R.id.tarifaRadioButton) as RadioButton

    lateinit var listener: OnRecyclerViewItemClick
    lateinit var tarifaSeleccionada: String

    init {
        individualRadioButton.setOnClickListener {
            listener.onSelectedItemClick(tarifaSeleccionada)
        }
    }

    fun bindData(tarifaItemClick: OnRecyclerViewItemClick, tarifa: String) {
        listener = tarifaItemClick
        tarifaSeleccionada = tarifa
    }
}

interface OnRecyclerViewItemClick {
    fun onSelectedItemClick(optionSelected: String)
}