package com.example.mirella.projetoretrofiteeroom.DAO

import android.arch.persistence.room.*
import com.example.mirella.projetoretrofiteeroom.model.Person

@Dao
interface PersonDao {

    @Insert
    fun insert(person: Person) : Long

    @Delete
    fun delete(person: Person)

    @Query("SELECT * FROM person")
    fun getPerson() : List<Person>

    @Query("SELECT * FROM person WHERE id = :personId")
    fun getPersonById(personId : Long) : Person

}