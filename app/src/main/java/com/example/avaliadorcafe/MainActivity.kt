package com.example.avaliadorcafe

import android.content.Intent
import android.os.Bundle
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
    }

    override fun onResume() {

        super.onResume()

        val db = AppDatabase.getDatabase(this)

        val lista = db.cafeDao().listar()

        val adapter = CafeAdapter(lista) {

        }

        binding.recyclerCafe.adapter = adapter
    }
}