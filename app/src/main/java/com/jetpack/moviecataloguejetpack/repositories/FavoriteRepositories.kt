package com.jetpack.moviecataloguejetpack.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.jetpack.moviecataloguejetpack.db.FavoriteDao
import com.jetpack.moviecataloguejetpack.db.FavoriteDatabase
import com.jetpack.moviecataloguejetpack.model.entity.movie.FavoriteMovie
import com.jetpack.moviecataloguejetpack.model.entity.tv.FavoriteTv
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepositories(application: Application) {

    private var favoriteDao: FavoriteDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()
        val db = FavoriteDatabase.getDatabase(application)
        favoriteDao = db?.favoriteDao()
    }

    // movie
    fun getAllFavoriteMovie() : LiveData<List<FavoriteMovie>>? {
        return favoriteDao?.getAllFavoriteMovie()
    }

    fun addToFavoriteMovie(favoriteMovie: FavoriteMovie) {
        executorService?.execute(Runnable { favoriteDao?.insertFavoriteMovie(favoriteMovie) })
    }

    fun removeFavoriteMovie(favoriteMovie: FavoriteMovie) {
        executorService?.execute(Runnable { favoriteDao?.deleteFavoriteMovie(favoriteMovie) })
    }

    fun getFavoriteMovieDetails(idMovie: String) : LiveData<FavoriteMovie>? {
        return favoriteDao?.getFavoriteMovieDetail(idMovie)
    }

    fun getAllFavoriteMoviePaging() : DataSource.Factory<Int, FavoriteMovie>? {
        return favoriteDao?.getAllFavoriteMoviePaging()
    }


    //tv
    fun getAllFavoriteTv() : LiveData<List<FavoriteTv>>? {
        return favoriteDao?.getAllFavoriteTv()
    }

    fun addToFavoriteTv(favoriteTv: FavoriteTv) {
        executorService?.execute(Runnable { favoriteDao?.insertFavoriteTv(favoriteTv) })
    }

    fun removeFavoriteTv(favoriteTv: FavoriteTv) {
        executorService?.execute(Runnable { favoriteDao?.deleteFavoriteTv(favoriteTv) })
    }

    fun getFavoriteTvDetails(idTv: String) : LiveData<FavoriteTv>? {
        return favoriteDao?.getFavoriteTvDetail(idTv)
    }

    fun getAllFavoriteTvPaging() : DataSource.Factory<Int, FavoriteTv>? {
        return favoriteDao?.getAllFavoriteTvPaging()
    }
}