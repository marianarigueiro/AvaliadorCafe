package com.example.avaliadorcafe

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.avaliadorcafe.data.AppDatabase
import com.example.avaliadorcafe.databinding.ActivityCadastroBinding
import com.example.avaliadorcafe.model.Cafe
import android.widget.ArrayAdapter

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val db = AppDatabase.getDatabase(this)

        val tagsDisponiveis = listOf(
            "Frutado",
            "Achocolatado",
            "Caramelo",
            "Cítrico",
            "Floral",
            "Intenso",
            "Suave"
        )

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            tagsDisponiveis
        )

        spinnerAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerTags.adapter = spinnerAdapter

        // Recebe o ID caso esteja editando
        val id = intent.getIntExtra("id", 0)

        // Preenche os campos se veio da edição
        if (id != 0) {

            binding.edtNome.setText(
                intent.getStringExtra("nome")
            )

            binding.edtMetodo.setText(
                intent.getStringExtra("metodo")
            )

            binding.edtNota.setText(
                intent.getStringExtra("nota")
            )

            binding.edtDescricao.setText(
                intent.getStringExtra("descricao")
            )

            val tagRecebida = intent.getStringExtra("tags")

            val posicao = tagsDisponiveis.indexOf(tagRecebida)

            if (posicao >= 0) {
                binding.spinnerTags.setSelection(posicao)
            }

            binding.btnSalvar.text = "Atualizar Café"
        }

        binding.btnSalvar.setOnClickListener {

            val cafe = Cafe(
                id = id,
                nome = binding.edtNome.text.toString(),
                metodo = binding.edtMetodo.text.toString(),
                nota = binding.edtNota.text.toString(),
                descricao = binding.edtDescricao.text.toString(),
                tags = binding.spinnerTags.selectedItem.toString()
            )

            if (id == 0) {

                db.cafeDao().inserir(cafe)

                Log.d("CAFE", "Café cadastrado com sucesso")

                Toast.makeText(
                    this,
                    "Café cadastrado!",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                db.cafeDao().atualizar(cafe)

                Log.d("CAFE", "Café atualizado com sucesso")

                Toast.makeText(
                    this,
                    "Café atualizado!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            finish()
        }
    }
}