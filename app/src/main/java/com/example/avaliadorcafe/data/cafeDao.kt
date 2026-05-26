package com.example.avaliadorcafe.data

import androidx.room.*
import com.example.avaliadorcafe.model.Cafe

@Dao
interface CafeDao {

    @Insert
    fun inserir(cafe: Cafe)

    @Update
    fun atualizar(cafe: Cafe)

    @Delete
    fun deletar(cafe: Cafe)

    @Query("SELECT * FROM cafes ORDER BY id DESC")
    fun listar(): List<Cafe>
}