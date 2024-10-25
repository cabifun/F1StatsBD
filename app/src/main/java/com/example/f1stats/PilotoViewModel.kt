package com.example.f1stats
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PilotoViewModel(private val repository: PilotoRepository) : ViewModel() {

    private val _todosPilotos = MutableLiveData<List<Piloto>>()
    val todosPilotos: LiveData<List<Piloto>> = MutableLiveData()

    var pilotos: List<Piloto> = listOf()

    fun loadPilotos() {
        viewModelScope.launch {
            (todosPilotos as MutableLiveData).value = repository.getAllPilotos()
        }
    }

    fun addPiloto(piloto: Piloto) {
        viewModelScope.launch {
            repository.insertPiloto(piloto)
            loadPilotos()
        }
    }

    fun removePiloto(id: Int) {
        viewModelScope.launch {
            repository.deletePiloto(id)
            loadPilotos()
        }
    }

}