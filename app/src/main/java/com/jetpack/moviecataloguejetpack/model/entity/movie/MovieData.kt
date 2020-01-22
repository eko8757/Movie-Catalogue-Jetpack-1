package com.jetpack.moviecataloguejetpack.model.entity.movie

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("results")
    val movieList: MutableList<MovieModel>?
)