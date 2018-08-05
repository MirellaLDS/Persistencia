package com.example.mirella.projetoretrofiteeroom

import android.app.Application
import com.example.mirella.projetoretrofiteeroom.DAO.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.getAppDatabase(this)
    }

}