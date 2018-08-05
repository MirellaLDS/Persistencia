package com.example.mirella.projetoretrofiteeroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mirella.projetoretrofiteeroom.App.Companion.instancia
import com.example.mirella.projetoretrofiteeroom.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var names = mutableListOf<String>()
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.emptyView = empty

        request.setOnClickListener { requestPersonRetrofit() }

        val listPerson = instancia.personDao().getPerson()
        names = listPerson.map { it.name }.toMutableList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        list.adapter = adapter
    }

    private fun requestRetrofit() {
        RequestRetrofit.loadMovies {
            val item = it as FilmResult
            Toast.makeText(this, item.results[0].title, Toast.LENGTH_LONG).show()
        }
    }

    private fun requestPersonRetrofit() {
        val number = (0..30).random()
        RequestRetrofit.person(number.toString(), {
            val item = it as Person
            val id = instancia.personDao().insert(item)
            updateList(id)
            Toast.makeText(this, item.name, Toast.LENGTH_LONG).show()
        })
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start

    private fun updateList(personId : Long) {
        val person = instancia.personDao().getPersonById(personId)
        names.add(person.name)
        adapter.notifyDataSetChanged()
    }

}
