package com.jetpack.moviecataloguejetpack.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.jetpack.moviecataloguejetpack.model.entity.movie.FavoriteMovie
import com.jetpack.moviecataloguejetpack.model.entity.tv.FavoriteTv

@Dao
interface FavoriteDao {

    // movie
    @Query("SELECT * FROM favorite_movies")
    fun getAllFavoriteMovie() : LiveData<List<FavoriteMovie>>

    @Query("SELECT * FROM favorite_movies WHERE idMovie LIKE :idMovie LIMIT 1")
    fun getFavoriteMovieDetail(idMovie: String) : LiveData<FavoriteMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDataFavorite: FavoriteMovie)

    @Delete
    fun deleteFavoriteMovie(movieDataFavorite: FavoriteMovie)

    @Query("SELECT * FROM favorite_movies ORDER BY idMovie ASC")
    fun getAllFavoriteMoviePaging() : DataSource.Factory<Int, FavoriteMovie>

    //tv
    @Query("SELECT * FROM favorite_tv")
    fun getAllFavoriteTv() : LiveData<List<FavoriteTv>>

    @Query("SELECT * FROM favorite_tv WHERE idTv LIKE :idTv LIMIT 1")
    fun getFavoriteTvDetail(idTv: String) : LiveData<FavoriteTv>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTv(tvDataFavorite: FavoriteTv)

    @Delete
    fun deleteFavoriteTv(tvDataFavorite: FavoriteTv)

    @Query("SELECT * FROM favorite_tv ORDER BY idTv ASC")
    fun getAllFavoriteTvPaging() : DataSource.Factory<Int, FavoriteTv>

}