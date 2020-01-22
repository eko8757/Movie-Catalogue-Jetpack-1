package com.jetpack.moviecataloguejetpack.model.entity.movie

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val voteAverage: Double?
)