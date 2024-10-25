package com.example.f1stats
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PilotoViewModelFactory(private val repository: PilotoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PilotoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PilotoViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel class desconhecida")
    }
}

