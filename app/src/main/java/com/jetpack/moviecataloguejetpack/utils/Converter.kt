package com.jetpack.moviecataloguejetpack.utils

import com.jetpack.moviecataloguejetpack.model.entity.movie.FavoriteMovie
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieDetail
import com.jetpack.moviecataloguejetpack.model.entity.tv.FavoriteTv
import com.jetpack.moviecataloguejetpack.model.entity.tv.TVShowDetail

object Converter {

    fun convertToFavoriteMovie(movie: MovieDetail) : FavoriteMovie {
        return FavoriteMovie(
            movie.idMovie,
            movie.overview,
            movie.posterPath,
            movie.releaseDate,
            movie.title,
            movie.voteAverage
        )
    }

    fun convertToFavoriteTv(tv: TVShowDetail) : FavoriteTv {
        return FavoriteTv(
            tv.idTv,
            tv.title,
            tv.overview,
            tv.posterPath,
            tv.firstAirDate,
            tv.voteAverage
        )
    }
}