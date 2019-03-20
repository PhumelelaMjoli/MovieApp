package com.example.movieapp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieRetrievalService
{
    @GET("/movies")
    fun getMovies(@Query("title") title: String,
                  @Query("rating") year: String,
                  @Query("release") release:String,
                  @Query("runtime") runtime:String,
                  @Query("genre") genre:String,
                  @Query("actor") actor:String,
                  @Query("plot") plot:String,
                  @Query("apiKey") apiKey: String) : Call<List<Movie>>
}