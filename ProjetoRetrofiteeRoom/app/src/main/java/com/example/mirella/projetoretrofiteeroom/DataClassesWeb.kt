package com.example.mirella.projetoretrofiteeroom

import com.google.gson.annotations.SerializedName

data class FilmResult(val results : List<Film>)

data class Film (val title : String,
                 @SerializedName("episode_id")
                 val episodeId : Int,
                 @SerializedName("characters")
                 val personUrls : List<String>)

data class Movie (val title : String,
                  val episodeId : Int,
                  val characters : MutableList<Character>)

data class Character(val name : String,
                     val gender : String){

    override fun toString(): String {
        return "$name / $gender"
    }
}