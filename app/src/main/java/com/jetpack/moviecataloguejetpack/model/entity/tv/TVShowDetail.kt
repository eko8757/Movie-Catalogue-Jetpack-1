package com.jetpack.moviecataloguejetpack.model.entity.tv

import com.google.gson.annotations.SerializedName

data class TVShowDetail(
    @SerializedName("id") val idTv: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?
)