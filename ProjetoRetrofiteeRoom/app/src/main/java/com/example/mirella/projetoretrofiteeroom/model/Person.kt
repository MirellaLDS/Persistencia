package com.example.mirella.projetoretrofiteeroom.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "person")
data class Person(@PrimaryKey(autoGenerate = true)
                  val id: Long,
                  val name: String = "",
                  val gender: String = "")