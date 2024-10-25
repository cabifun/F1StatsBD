package com.example.f1stats
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pilotos")
data class Piloto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val vitorias: Int,
    val podios: Int,
    val pontos: Int,
    val corridas: Int
)
