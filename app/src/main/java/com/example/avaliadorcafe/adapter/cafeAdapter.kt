package com.example.avaliadorcafe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliadorcafe.databinding.ItemCafeBinding
import com.example.avaliadorcafe.model.Cafe

class CafeAdapter(
    private val lista: List<Cafe>,
    private val onClick: (Cafe) -> Unit
) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    inner class CafeViewHolder(val binding: ItemCafeBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {

        val binding = ItemCafeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CafeViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {

        val cafe = lista[position]

        holder.binding.txtNome.text = cafe.nome
        holder.binding.txtMetodo.text = "Método: ${cafe.metodo}"
        holder.binding.txtNota.text = "Nota: ${cafe.nota}"
        holder.binding.txtTags.text = "Tags: ${cafe.tags}"

        holder.itemView.setOnClickListener {
            onClick(cafe)
        }
    }
}