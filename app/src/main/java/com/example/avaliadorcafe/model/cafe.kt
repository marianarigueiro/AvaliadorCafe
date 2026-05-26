package com.example.avaliadorcafe.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cafes")
data class Cafe(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val metodo: String,
    val nota: String,
    val descricao: String,
    val tags: String
)