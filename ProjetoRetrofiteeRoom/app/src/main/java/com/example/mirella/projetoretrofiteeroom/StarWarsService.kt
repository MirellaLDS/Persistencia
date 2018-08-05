package com.example.mirella.projetoretrofiteeroom

import com.example.mirella.projetoretrofiteeroom.model.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsService {
    @GET("films")
    fun listMovies(): Call<FilmResult>

    @GET("people/{personId}")
    fun loadPerson(@Path("personId") personId: String): Call<Person>
}