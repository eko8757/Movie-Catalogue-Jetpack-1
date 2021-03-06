package com.jetpack.moviecataloguejetpack.model.entity.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieModel (
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @SerializedName("id") val idMovie: String?,

    @ColumnInfo(name = "title")
    @SerializedName("title") val title: String?,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date") val releaseDate: String?,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") val voteAverage: Double?,

    @ColumnInfo(name = "overview")
    @SerializedName("overview") val overview: String?,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path") val posterPath: String?
)