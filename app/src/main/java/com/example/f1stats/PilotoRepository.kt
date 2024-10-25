package com.example.f1stats

import androidx.lifecycle.LiveData

class PilotoRepository(private val pilotoDao: PilotoDao) {

    fun getAllPilotos(): LiveData<List<Piloto>> {
        return pilotoDao.getAllPilotos()
    }

    suspend fun insertPiloto(piloto: Piloto) {
        pilotoDao.insertPiloto(piloto)
    }

    suspend fun deletePiloto(id: Int) {
        pilotoDao.deletePiloto(id)
    }
}