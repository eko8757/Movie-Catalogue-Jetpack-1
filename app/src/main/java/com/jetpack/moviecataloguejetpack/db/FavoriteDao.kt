package com.jetpack.moviecataloguejetpack.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.TvModel

interface FavoriteDao {

    // movie
    @Query("SELECT * FROM movies")
    fun getAllFavoriteMovie() : LiveData<List<MovieModel>>

    @Query("SELECT * FROM movies WHERE movie_id LIKE :idMovie LIMIT 1")
    fun getFavoriteMovieDetail(idMovie: String) : LiveData<MovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDataFavorite: MovieModel)

    @Delete
    fun deleteFavoriteMovie(movieDataFavorite: MovieModel)

    //tv
    @Query("SELECT * FROM tvshow")
    fun getAllFavoriteTv() : LiveData<List<TvModel>>

    @Query("SELECT * FROM tvshow WHERE tv_id LIKE :idTv LIMIT 1")
    fun getFavoritetvDetail(idTv: String) : LiveData<TvModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTv(tvDataFavorite: TvModel)

    @Delete
    fun deleteFavoriteTv(tvDataFavorite: TvModel)

}