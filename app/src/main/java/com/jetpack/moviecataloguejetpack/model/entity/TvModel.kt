package com.jetpack.moviecataloguejetpack.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TvData(
    @SerializedName("results")
    val tvList: MutableList<TvModel>?
)

@Entity(tableName = "tvshow")
data class TvModel(
    @PrimaryKey
    @ColumnInfo(name = "tv_id")
    @SerializedName("id") val idTVShow: String?,

    @ColumnInfo(name = "original_name")
    @SerializedName("original_name") val originalName: String?,

    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date") val airDate: String?,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") val voteAverage: Double?,

    @ColumnInfo(name = "overview")
    @SerializedName("overview") val overview: String?,

    @ColumnInfo(name = "poster_path")
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