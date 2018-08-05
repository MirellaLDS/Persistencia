package com.example.mirella.projetoretrofiteeroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mirella.projetoretrofiteeroom.App.Companion.instancia
import com.example.mirella.projetoretrofiteeroom.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.emptyView = empty

        request.setOnClickListener { requestPersonRetrofit() }

        val listPerson = instancia.personDao().getPerson()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOf(listPerson.name))

        list.adapter = adapter
    }

    private fun requestRetrofit() {
        RequestRetrofit.loadMovies {
            val item = it as FilmResult
            Toast.makeText(this, item.results[0].title, Toast.LENGTH_LONG).show()
        }
    }

    private fun requestPersonRetrofit() {
        RequestRetrofit.person {
            val item = it as Person
            instancia.personDao().insert(item)
            Toast.makeText(this, item.name, Toast.LENGTH_LONG).show()
        }
    }

}
