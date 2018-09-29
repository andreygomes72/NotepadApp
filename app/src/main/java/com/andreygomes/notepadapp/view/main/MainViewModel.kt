package com.andreygomes.notepadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.andreygomes.notepadapp.model.Nota
import com.andreygomes.notepadapp.repository.NotaRepository

class MainViewModel : ViewModel() {
    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos() {
        notaRepository
                .buscarTodos(onComplete = {
                    isLoading.value = false
                    notas.value = it
                }, onError = {
                    isLoading.value = false
                    notas.value = mutableListOf()
                })
    }
}