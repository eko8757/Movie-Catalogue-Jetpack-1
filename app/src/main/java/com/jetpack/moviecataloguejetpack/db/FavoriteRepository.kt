package com.jetpack.moviecataloguejetpack.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.TvModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepository(application: Application) {

    private var favoriteDao: FavoriteDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()
        val db = FavoriteDatabase.getDatabase(application)
        favoriteDao = db?.favoriteDao()
    }

    // movie
    fun getAllFavoriteMovie() : LiveData<List<MovieModel>>? {
        return favoriteDao?.getAllFavoriteMovie()
    }

    fun addToFavoriteMovie(favoriteMovie: MovieModel) {
        executorService?.execute(Runnable { favoriteDao?.insertFavoriteMovie(favoriteMovie) })
    }

    fun removeFavoriteMovie(favoriteMovie: MovieModel) {
        executorService?.execute(Runnable { favoriteDao?.deleteFavoriteMovie(favoriteMovie) })
    }


    //tv
    fun getAllFavoriteTv() : LiveData<List<TvModel>>? {
        return favoriteDao?.getAllFavoriteTv()
    }

    fun addToFavoriteTv(favoriteTv: TvModel) {
        executorService?.execute(Runnable { favoriteDao?.insertFavoriteTv(favoriteTv) })
    }

    fun removeFavoriteTv(favoriteTv: TvModel) {
        executorService?.execute(Runnable { favoriteDao?.deleteFavoriteTv(favoriteTv) })
    }
}