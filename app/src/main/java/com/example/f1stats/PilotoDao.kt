package com.example.f1stats
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PilotoDao {
    @Query("SELECT * FROM pilotos")
    fun getAllPilotos(): LiveData<List<Piloto>>

    @Insert
    suspend fun insertPiloto(piloto: Piloto)

    @Query("DELETE FROM pilotos WHERE id = :id")
    suspend fun deletePiloto(id: Int)
}