package com.example.mirella.projetoretrofiteeroom.DAO

import android.arch.persistence.room.*
import com.example.mirella.projetoretrofiteeroom.model.Person

@Dao
interface PersonDao {

    @Insert
    fun insert(person: Person) : Long

    @Delete
    fun delete(person: Person)

    @Query("SELECT * FROM Person")
    fun getAll(person: Person)
}