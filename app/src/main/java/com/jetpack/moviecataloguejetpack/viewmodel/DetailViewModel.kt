package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpack.moviecataloguejetpack.repositories.MainRepositories
import com.jetpack.moviecataloguejetpack.model.entity.MovieDetail
import com.jetpack.moviecataloguejetpack.model.entity.TVShowDetail

class DetailViewModel : ViewModel() {
    private val repository = MainRepositories()
    private var movieDetail: MutableLiveData<MovieDetail>? = null
    private var tvShowDetail: MutableLiveData<TVShowDetail>? = null

    fun getMovieDetailData(movieId: String?) : MutableLiveData<MovieDetail>? {
        if (movieDetail == null) movieDetail = repository.fetchDataMovieDetail(movieId)
        return movieDetail
    }

    fun getTVDetailData(tvId: String?) : MutableLiveData<TVShowDetail>? {
        if (tvShowDetail == null) tvShowDetail = repository.fetchDataTvDetail(tvId)
        return tvShowDetail
    }
}