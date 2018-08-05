package com.example.mirella.projetoretrofiteeroom.DAO

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.mirella.projetoretrofiteeroom.model.Person

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {

        private lateinit var instance: AppDatabase

        fun getAppDatabase(context:Context): AppDatabase {
            instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "StarWars"
            ).allowMainThreadQueries()
                    .build()
            return instance
        }
    }


}