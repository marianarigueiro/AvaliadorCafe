package com.example.avaliadorcafe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliadorcafe.R
import com.example.avaliadorcafe.databinding.ItemCafeBinding
import com.example.avaliadorcafe.model.Cafe

class CafeAdapter(
    private val lista: List<Cafe>,
    private val onEditar: (Cafe) -> Unit,
    private val onExcluir: (Cafe) -> Unit
) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    inner class CafeViewHolder(
        val binding: ItemCafeBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CafeViewHolder {

        val binding = ItemCafeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CafeViewHolder(binding)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(
        holder: CafeViewHolder,
        position: Int
    ) {

        val cafe = lista[position]

        val context = holder.itemView.context

        holder.binding.txtNome.text = cafe.nome

        holder.binding.txtMetodo.text =
            context.getString(R.string.metodo, cafe.metodo)

        holder.binding.txtNota.text =
            context.getString(R.string.nota, cafe.nota)

        holder.binding.txtDescricao.text = cafe.descricao

        holder.binding.txtTags.text =
            context.getString(R.string.categoria_sensorial, cafe.tags)

        holder.binding.btnEditar.setOnClickListener {
            onEditar(cafe)
        }

        holder.binding.btnExcluir.setOnClickListener {
            onExcluir(cafe)
        }
    }
}