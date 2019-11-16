package com.jetpack.moviecataloguejetpack.model.entity

import com.google.gson.annotations.SerializedName

data class TvData(
    @SerializedName("results")
    val tvList: MutableList<TvModel>?
)

data class TvModel(
    @SerializedName("id") val idTVShow: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("first_air_date") val airDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?
)

data class TVShowDetail(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?
)