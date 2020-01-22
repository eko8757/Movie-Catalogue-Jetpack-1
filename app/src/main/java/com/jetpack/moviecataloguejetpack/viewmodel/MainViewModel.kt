package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpack.moviecataloguejetpack.repositories.MainRepositories
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.tv.TvModel

class MainViewModel: ViewModel() {
    private var repository = MainRepositories()
    private var movieList: MutableLiveData<MutableList<MovieModel>>? = null
    private var tvList: MutableLiveData<MutableList<TvModel>>? = null

    fun getMovieList() : MutableLiveData<MutableList<MovieModel>>? {
        if (movieList == null) movieList = repository.fetchMovieData()
        return movieList
    }

    fun getTvList() : MutableLiveData<MutableList<TvModel>>? {
        if (tvList == null) tvList = repository.fetchTvData()
        return tvList
    }
}