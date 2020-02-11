package com.example.delsurverificacin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_seleccion_tarifa_rv.view.*

class DialogFragmentRecyclerViewAdapter(
    private var dataForRecycler: List<String>,
    private val listener: (String) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RadioButtonViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_seleccion_tarifa_rv, parent, false))
    }

    override fun getItemCount() = dataForRecycler.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val radioButtonViewHolder = holder as RadioButtonViewHolder
        radioButtonViewHolder.bindItemView(dataForRecycler[position], listener)
    }
}

class RadioButtonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItemView(tipoDeTarifa: String, listener: (String) -> Unit) {
        itemView.tarifaRadioButton.text = tipoDeTarifa

        itemView.setOnClickListener {
            listener(tipoDeTarifa)
        }
    }
}