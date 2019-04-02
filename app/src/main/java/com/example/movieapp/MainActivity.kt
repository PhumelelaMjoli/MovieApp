package com.example.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.movieapp.R.layout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        GetMovie()
        //val movies= RetrofitClient.getMovies( Title= "big mama", apiKey="44afc44f")

        //val request = RetrofitClient.movieRetrievalService.getMovie(Title="Avatar", apiKey="44afc44f", Year = "", Rated = "", Released = "", Runtime = "", Director = "", Genre = "")

        // dMessage.text = RetrofitClient.movie
        // Log.d("Movies response after", movies.toString())


        //  val movieCallback = MovieCallback()
        // request.enqueue(movieCallback)

    }


//    val request = RetrofitClient.movieRetrievalService.getMoviesRequest(Title, Year, Rated, Released, Runtime, Genre, Director, apiKey)
///       val movieCallback = MovieCallback()
//    request.enqueue(movieCallback)

    inner class MovieCallback : Callback<Movie> {
        override fun onFailure(call: Call<Movie>, t: Throwable) {
            Log.d("Movies response error", t.toString())

        }


        override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
            //RetrofitClient.movie = response.body()
            val movie: Movie? = response.body()

            Picasso.get().load(movie?.img).into(movieImageView)

            movieTitleTextView.text = "Title:" + movie?.title.toString()
            yearTextView.text = "Year:" + movie?.year.toString()
            ratedTextView.text = "Rated:" + movie?.rated.toString()
            releasedTextView.text = "Released:" + movie?.released.toString()
            runtimeTextView.text = "Runtime:" + movie?.runtime.toString()
            genreTextView.text = "Genre:" + movie?.genre.toString()
            directorTextView.text = "Director :" + movie?.director.toString()
            actorsTextView.text = movie?.actors.toString()

            Log.d("", movie.toString())
        }

    }

    private fun GetMovie() {

        val movies = findViewById<EditText>(R.id.dMessage)

        val title = findViewById<EditText>(R.id.edit_query).text
        val searchButton = findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            val request = RetrofitClient.movieRetrievalService.getMovie(
                Title = title.toString(),
                apiKey = "44afc44f",
                Year = "",
                Rated = "",
                Released = "",
                Runtime = "",
                Director = "",
                Genre = ""
            )
            Log.d("Movies request ", request.toString())
            Log.d("Movies response after", title.toString())

            request.enqueue(MovieCallback())
        }

    }
}




