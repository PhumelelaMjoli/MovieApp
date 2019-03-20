package com.example.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val textview: TextView = findViewById(R.id.textView)

       // val textView: TextView = findViewById(R.id.title)
        //val textView2: TextView = findViewById(R.id.rating)
        //val textView3: TextView = findViewById(R.id.release)
       // val textView4: TextView = findViewById(R.id.runtime)
       // val textView5: TextView = findViewById(R.id.genre)
       // val textView6: TextView = findViewById(R.id.actor)
        //val textView7: TextView = findViewById(R.id.plot)






        val movies= RetrofitClient.getMovies( title= "Fast and Furious", apiKey="835c826c")
        textview.text = movies.toString()

    }
}
