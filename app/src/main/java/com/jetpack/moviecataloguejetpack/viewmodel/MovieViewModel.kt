package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.jetpack.moviecataloguejetpack.model.DataDummy
import com.jetpack.moviecataloguejetpack.model.MovieModel

class MovieViewModel: ViewModel() {
    val movies: List<MovieModel> = DataDummy.generateMovies()
    fun movieDetail(id: Int): MovieModel? = DataDummy.movieDetail(id)
}