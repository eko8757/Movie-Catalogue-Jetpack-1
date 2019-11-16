package com.jetpack.moviecataloguejetpack.model.network

import com.jetpack.moviecataloguejetpack.model.entity.MovieData
import com.jetpack.moviecataloguejetpack.model.entity.MovieDetail
import com.jetpack.moviecataloguejetpack.model.entity.TVShowDetail
import com.jetpack.moviecataloguejetpack.model.entity.TvData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMovie {

    @GET("discover/movie?")
    fun getDiscoverMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ) : Call<MovieData>

    @GET("tv/popular?")
    fun getDiscoverTv(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ) : Call<TvData>

    @GET("movie/{movieId}")
    fun getMovieDetail(
        @Path("movieId") movieId: String?,
        @Query("api_key") apiKey: String
    ): Call<MovieDetail>

    @GET("tv/{tvShowId}")
    fun getTVShowDetail(
        @Path("tvShowId") tvShowId: String?,
        @Query("api_key") apiKey: String
    ): Call<TVShowDetail>
}