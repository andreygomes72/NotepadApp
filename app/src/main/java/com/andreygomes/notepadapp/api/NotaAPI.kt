package com.andreygomes.notepadapp.api

import com.andreygomes.notepadapp.model.Nota
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NotaAPI {
    @GET("/nota")
    fun buscarTodos(): Call<List<Nota>>

    @GET("/nota/titulo/{totulo}")
    fun buscarPorTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/nota")
    fun salvar(nota: Nota): Call<Nota>

    @DELETE("/nota/{id}")
    fun apagar(@Path("id") id: String): Call<Void>
}