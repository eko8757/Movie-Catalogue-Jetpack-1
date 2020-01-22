package com.jetpack.moviecataloguejetpack.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.jetpack.moviecataloguejetpack.repositories.FavoriteRepositories
import androidx.lifecycle.MutableLiveData
import com.jetpack.moviecataloguejetpack.model.entity.tv.TVShowDetail
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieDetail
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jetpack.moviecataloguejetpack.model.entity.movie.FavoriteMovie
import com.jetpack.moviecataloguejetpack.model.entity.tv.FavoriteTv
import com.jetpack.moviecataloguejetpack.repositories.MainRepositories
import com.jetpack.moviecataloguejetpack.utils.Converter

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val favoritesRepository: FavoriteRepositories = FavoriteRepositories(application)
    private val repo: MainRepositories = MainRepositories()
    private var favoriteMovieLiveData: LiveData<FavoriteMovie>? = null
    private var favoriteTvLiveData: LiveData<FavoriteTv>? = null
    private var movieDetail: MutableLiveData<MovieDetail>? = null
    private var tvShowDetail: MutableLiveData<TVShowDetail>? = null

    //movie
    fun checkIsMovieFavorite(movieID: String): LiveData<FavoriteMovie>? {
        favoriteMovieLiveData = favoritesRepository.getFavoriteMovieDetails(movieID)
        return favoriteMovieLiveData
    }

    fun insertFavoriteMovie(movie: FavoriteMovie) {
        favoritesRepository.addToFavoriteMovie(movie)
    }

    fun insertFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovies = Converter.convertToFavoriteMovie(movie)
        favoritesRepository.addToFavoriteMovie(favoriteMovies)
    }

    fun removeFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovies = Converter.convertToFavoriteMovie(movie)
        favoritesRepository.removeFavoriteMovie(favoriteMovies)
    }

    fun removeFavoriteMovie(movie: FavoriteMovie) {
        favoritesRepository.removeFavoriteMovie(movie)
    }

    fun getMoviesDetailWithID(movieId: String): MutableLiveData<MovieDetail>? {
        if (movieDetail == null) movieDetail = repo.fetchDataMovieDetail(movieId)
        return movieDetail
    }

    fun getFavoriteMovieDetails(movieId: String?) : LiveData<FavoriteMovie>? {
        if (favoriteMovieLiveData == null) {
            favoriteMovieLiveData = movieId?.let { favoritesRepository.getFavoriteMovieDetails(it) }
        }
        return favoriteMovieLiveData
    }

    fun getAllFavoriteMoviePaging() : LiveData<PagedList<FavoriteMovie>> {
        return LivePagedListBuilder(favoritesRepository.getAllFavoriteMoviePaging()!!, 5).build()
    }


    //tv
    fun checkIsTvFavorite(tvID: String) : LiveData<FavoriteTv>? {
        favoriteTvLiveData = favoritesRepository.getFavoriteTvDetails(tvID)
        return favoriteTvLiveData
    }

    fun insertFavoriteTvData(tv: TVShowDetail) {
        val favoritesTV = Converter.convertToFavoriteTv(tv)
        favoritesRepository.addToFavoriteTv(favoritesTV)
    }

    fun insertFavoriteTv(tv: FavoriteTv) {
        favoritesRepository.addToFavoriteTv(tv)
    }

    fun removeFavoriteTvData(tv: TVShowDetail) {
        val favoritesTv = Converter.convertToFavoriteTv(tv)
        favoritesRepository.removeFavoriteTv(favoritesTv)
    }

    fun removeFavoriteTv(tv: FavoriteTv) {
        favoritesRepository.removeFavoriteTv(tv)
    }

    fun getTVShowDetails(tvShowId: String?) : LiveData<FavoriteTv>? {
        if (favoriteTvLiveData == null) {
            favoriteTvLiveData = tvShowId?.let { favoritesRepository.getFavoriteTvDetails(it) }
        }
        return favoriteTvLiveData
    }

    fun getTVShowDetailWithId(tvShowId: String): MutableLiveData<TVShowDetail>? {
        if (tvShowDetail == null) tvShowDetail = repo.fetchDataTvDetail(tvShowId)
        return tvShowDetail
    }

    fun getAllFavoriteTvPaging() : LiveData<PagedList<FavoriteTv>> {
        return LivePagedListBuilder(favoritesRepository.getAllFavoriteTvPaging()!!, 5).build()
    }
}
