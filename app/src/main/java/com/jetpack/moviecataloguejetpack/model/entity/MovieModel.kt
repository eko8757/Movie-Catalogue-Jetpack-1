package com.jetpack.moviecataloguejetpack.model.entity

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("results")
    val movieList: MutableList<MovieModel>?
)

data class MovieModel (
    @SerializedName("id") val idMovie: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?
)

data class MovieDetail(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val voteAverage: Double?
)