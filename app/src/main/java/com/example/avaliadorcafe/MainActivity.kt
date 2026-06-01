package com.example.avaliadorcafe

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
                Intent(
                    this,
                    CadastroActivity::class.java
                )
            )
        }
    }

    override fun onResume() {

        super.onResume()

        carregarCafes()
    }

    private fun carregarCafes() {

        val db = AppDatabase.getDatabase(this)

        val lista = db.cafeDao().listar()

        val adapter = CafeAdapter(

            lista,

            onEditar = { cafe ->

                val intent = Intent(
                    this,
                    CadastroActivity::class.java
                )

                intent.putExtra("id", cafe.id)
                intent.putExtra("nome", cafe.nome)
                intent.putExtra("metodo", cafe.metodo)
                intent.putExtra("nota", cafe.nota)
                intent.putExtra("descricao", cafe.descricao)
                intent.putExtra("tags", cafe.tags)

                startActivity(intent)
            },

            onExcluir = { cafe ->

                db.cafeDao().deletar(cafe)

                Toast.makeText(
                    this,
                    "Café removido com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                carregarCafes()
            }
        )

        binding.recyclerCafe.adapter = adapter
    }
}