package com.example.avaliadorcafe

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.avaliadorcafe.data.AppDatabase
import com.example.avaliadorcafe.databinding.ActivityCadastroBinding
import com.example.avaliadorcafe.model.Cafe

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val db = AppDatabase.getDatabase(this)

        binding.btnSalvar.setOnClickListener {

            val cafe = Cafe(
                nome = binding.edtNome.text.toString(),
                metodo = binding.edtMetodo.text.toString(),
                nota = binding.edtNota.text.toString(),
                descricao = binding.edtDescricao.text.toString(),
                tags = binding.edtTags.text.toString()
            )

            db.cafeDao().inserir(cafe)

            Log.d("CAFÉ", "Café salvo com sucesso!")

            Toast.makeText(this, "Café cadastrado!", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}