package com.example.movieapp

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title")
    var title: String = "",
    @SerializedName("Year")
    var year: String = "",
    @SerializedName("Rated")
    var rated: String = "",
    @SerializedName("Released")
    var released: String = "",
    @SerializedName("Runtime")
    var runtime: String = "",
    @SerializedName("Genre")
    var genre: String = "",
    @SerializedName("Director")
    var director: String = "",
    @SerializedName("Actors")
    var actors: String = ""
)










