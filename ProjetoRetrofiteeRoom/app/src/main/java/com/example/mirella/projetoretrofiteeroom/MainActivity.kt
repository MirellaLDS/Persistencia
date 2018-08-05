package com.example.mirella.projetoretrofiteeroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestRetrofit()

        request.setOnClickListener { requestRetrofit() }


    }

    private fun requestRetrofit() {
        RequestRetrofit.loadMovies {
            val item = it as FilmResult
            Toast.makeText(this, item.results[0].title, Toast.LENGTH_LONG).show()
        }
    }

}
