package com.example.avaliadorcafe

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliadorcafe.adapter.CafeAdapter
import com.example.avaliadorcafe.data.AppDatabase
import com.example.avaliadorcafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerCafe.layoutManager =
            LinearLayoutManager(this)

        binding.btnAdicionar.setOnClickListener {
            startActivity(
                Intent(this, CadastroActivity::class.java)
            )
        }

        binding.edtPesquisa.addTextChangedListener(
            object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?, start: Int, count: Int, after: Int
                ) {}

                override fun onTextChanged(
                    s: CharSequence?, start: Int, before: Int, count: Int
                ) {
                    filtrarCafes(s.toString())
                }

                override fun afterTextChanged(s: Editable?) {}
            }
        )
    }

    override fun onResume() {
        super.onResume()
        carregarCafes()
    }

    private fun carregarCafes() {

        val db = AppDatabase.getDatabase(this)

        val lista = db.cafeDao().listar()

        val listaOrdenada = lista.sortedBy { it.nome }

        binding.txtQuantidade.text =
            getString(R.string.cafes_cadastrados, listaOrdenada.size)

        binding.recyclerCafe.adapter =
            criarAdapter(listaOrdenada)
    }

    private fun filtrarCafes(texto: String) {

        val db = AppDatabase.getDatabase(this)

        val listaCompleta = db.cafeDao().listar()

        val listaFiltrada = listaCompleta.filter {
            it.nome.contains(texto, ignoreCase = true)
        }

        binding.txtQuantidade.text =
            getString(R.string.cafes_encontrados, listaFiltrada.size)

        binding.recyclerCafe.adapter =
            criarAdapter(listaFiltrada)
    }

    private fun criarAdapter(lista: List<com.example.avaliadorcafe.model.Cafe>) =
        CafeAdapter(
            lista,

            onEditar = { cafe ->
                val intent = Intent(this, CadastroActivity::class.java).apply {
                    putExtra("id", cafe.id)
                    putExtra("nome", cafe.nome)
                    putExtra("metodo", cafe.metodo)
                    putExtra("nota", cafe.nota)
                    putExtra("descricao", cafe.descricao)
                    putExtra("tags", cafe.tags)
                }
                startActivity(intent)
            },

            onExcluir = { cafe ->

                val db = AppDatabase.getDatabase(this)

                AlertDialog.Builder(this)
                    .setTitle("Excluir Café")
                    .setMessage("Deseja realmente excluir \"${cafe.nome}\"?")
                    .setPositiveButton("Excluir") { _, _ ->
                        db.cafeDao().deletar(cafe)
                        carregarCafes()
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            }
        )
}