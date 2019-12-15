package com.jetpack.moviecataloguejetpack.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.moviecataloguejetpack.db.FavoriteRepository
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.TvModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : ViewModel() {

    private val favoriteRepository by lazy { FavoriteRepository(application) }

    //movie
    fun getAllFavoriteMovie() : LiveData<List<MovieModel>>? {
        return favoriteRepository.getAllFavoriteMovie()
    }

    fun insertMovie(favoriteMovie: MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepository.addToFavoriteMovie(favoriteMovie)
    }

    fun deleteMovie(favoriteMovie: MovieModel) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepository.removeFavoriteMovie(favoriteMovie)
    }

    //tv
    fun getAllFavoriteTv() : LiveData<List<TvModel>>? {
        return favoriteRepository.getAllFavoriteTv()
    }

    fun insertTv(favoriteTv: TvModel) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepository.addToFavoriteTv(favoriteTv)
    }

    fun deleteTv(favoriteTv: TvModel) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepository.removeFavoriteTv(favoriteTv)
    }
}