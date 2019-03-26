package com.example.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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





        val movies= RetrofitClient.getMovies( Title= "big mama", apiKey="44afc44f")


//        //textview.text = movies.toString()
//        Log.d("Movies response after", movies.toString())

//        val request = RetrofitClient.movieRetrievalService.getMovies(Title, Year, Rated, Released, Runtime, Genre, Director, apiKey)
      MovieCallback()
//        request.enqueue(movieCallback)

    }


//    val request = RetrofitClient.movieRetrievalService.getMovies(Title, Year, Rated, Released, Runtime, Genre, Director, apiKey)
///       val movieCallback = MovieCallback()
//    request.enqueue(movieCallback)


}


class MovieCallback : Callback<Movie> {
    override fun onFailure(call: Call<Movie>, t: Throwable) {
        Log.d("Movies response error", t.toString())

    }

    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
        RetrofitClient.movie = response.body()
        Log.d("Movies response success after ", RetrofitClient.movie.toString())
    }
}

