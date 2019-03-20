package com.example.movieapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var baseUrl: String = "http://www.omdbapi.com/"
    lateinit var movieRetrievalService: MovieRetrievalService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        movieRetrievalService = retrofit.create(MovieRetrievalService::class.java)
    }

    fun getMovies(
        title: String="",
        year: String="",
        release: String="",
        runtime: String="",
        genre: String="",
        actor: String="",
        plot: String="",
        apiKey:String=""
    ): List<Movie>? {
        val request = movieRetrievalService.getMovies(title, year, release, runtime, genre, actor, plot, apiKey)
        request.enqueue(MovieCallback())

        /*if (response.isSuccessful) {
            return response.body()
        }*/

        return null
    }

}

class MovieCallback : Callback<List<Movie>> {
    override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
        Log.d("Movies response error", t.toString())
    }

    override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
        Log.d("Movies response success", response.toString())
    }
}