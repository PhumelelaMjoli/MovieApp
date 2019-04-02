package com.example.movieapp

import android.util.Log
import com.example.movieapp.RetrofitClient.movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var baseUrl: String = "http://www.omdbapi.com"
    lateinit var movieRetrievalService: MovieRetrievalService
    var movie: Movie? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        movieRetrievalService = retrofit.create(MovieRetrievalService::class.java)
    }
fun getData():Movie?{
    return movie
}

    fun getMovies(
        Title: String = "",
        Year: String = "",
        Rated: String = "",
        Released: String = "",
        Runtime: String = "",
        Genre: String = "",
        Director: String = "",
        apiKey: String = ""
    ): List<Movie>? {
        //val request = movieRetrievalService.getMoviesRequest(Title, Year, Rated, Released, Runtime, Genre, Director, apiKey)
       // val movieCallback = MovieCallback()
        //request.enqueue(movieCallback)

        /*if (response.isSuccessful) {
            return response.body()
        }*/

        return null
    }

}

//class MovieCallback : Callback<Movie> {
//    override fun onFailure(call: Call<Movie>, t: Throwable) {
//        Log.d("Movies response error", t.toString())
//
//    }
//
//    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
//        movie = response.body()
//        Log.d("Movies response success", movie.toString())
//    }
