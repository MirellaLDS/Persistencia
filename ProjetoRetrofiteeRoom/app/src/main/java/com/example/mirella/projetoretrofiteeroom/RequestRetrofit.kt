package com.example.mirella.projetoretrofiteeroom

import android.util.Log
import com.example.mirella.projetoretrofiteeroom.model.Person
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestRetrofit {

    private val service: StarWarsService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

        service = retrofit.create<StarWarsService>(StarWarsService::class.java)
    }

    fun loadMovies(success : (Any) -> Unit) {
        val call = service.listMovies()

        call.enqueue(object: Callback<FilmResult> {
            override fun onFailure(call: Call<FilmResult>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }

            override fun onResponse(call: Call<FilmResult>?, response: Response<FilmResult>?) {
                response?.body()?.let {
                    val film = it
                    success(film)

                    Log.e("onFailure error", "Sucesso")
                }
            }
        })
    }

    fun person(personId : String, success : (Any) -> Unit){
        val call = service.loadPerson(personId)

        call.enqueue(object : Callback<Person> {
            override fun onFailure(call: Call<Person>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }

            override fun onResponse(call: Call<Person>?, response: Response<Person>?) {
                response?.body()?.let {
                    val film = it
                    success(film)

                    Log.e("onFailure error", "Sucesso")
                }
            }
        })
    }
}