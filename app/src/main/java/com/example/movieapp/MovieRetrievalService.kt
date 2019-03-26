package com.example.movieapp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieRetrievalService
{
    @GET("/?")
    fun getMovies(@Query("t") Title: String,
                  @Query("year") Year: String,
                  @Query("rated") Rated:String,
                  @Query("released") Released:String,
                  @Query("runtime") Runtime:String,
                  @Query("genre") Genre:String,
                  @Query("director") Director:String,
                  @Query("apiKey") apiKey: String) : Call<Movie>
}