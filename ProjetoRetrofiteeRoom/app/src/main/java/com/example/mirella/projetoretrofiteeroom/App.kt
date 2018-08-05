package com.example.mirella.projetoretrofiteeroom

import android.app.Application
import com.example.mirella.projetoretrofiteeroom.DAO.AppDatabase
import com.facebook.stetho.Stetho

class App : Application() {

    companion object {
        lateinit var instancia : AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        instancia = AppDatabase.getAppDatabase(this)
        Stetho.initializeWithDefaults(this)
    }

}