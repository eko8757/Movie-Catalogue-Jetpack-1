package com.jetpack.moviecataloguejetpack.repositories

import androidx.lifecycle.MutableLiveData
import com.jetpack.moviecataloguejetpack.BuildConfig
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieData
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieDetail
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.tv.TVShowDetail
import com.jetpack.moviecataloguejetpack.model.entity.tv.TvData
import com.jetpack.moviecataloguejetpack.model.entity.tv.TvModel
import com.jetpack.moviecataloguejetpack.model.network.ApiMovie
import com.jetpack.moviecataloguejetpack.services.BaseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositories {

    val TAG = "Fixture Repository"
    private val placeHolderApi: ApiMovie = BaseApi.createService(ApiMovie::class.java)

    //movie
    fun fetchMovieData(): MutableLiveData<MutableList<MovieModel>>? {
        val movieList = MutableLiveData<MutableList<MovieModel>>()
        val call = placeHolderApi.getDiscoverMovie(BuildConfig.API_V3_KEY, "en")
        call.enqueue(object : Callback<MovieData?> {
            override fun onFailure(call: Call<MovieData?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieData?>, response: Response<MovieData?>) {
                movieList.value = response.body()?.movieList
            }
        })

        return movieList
    }

    //tv
    fun fetchTvData(): MutableLiveData<MutableList<TvModel>>? {
        val tvList = MutableLiveData<MutableList<TvModel>>()
        val call = placeHolderApi.getDiscoverTv(BuildConfig.API_V3_KEY, "en")
        call.enqueue(object : Callback<TvData?> {
            override fun onFailure(call: Call<TvData?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TvData?>, response: Response<TvData?>) {
                tvList.value = response.body()?.tvList
            }
        })

        return tvList
    }

    //detail movie
    fun fetchDataMovieDetail(movieId: String?) : MutableLiveData<MovieDetail>? {
        val movie = MutableLiveData<MovieDetail>()
        val call = placeHolderApi.getMovieDetail(movieId, BuildConfig.API_V3_KEY)
        call.enqueue(object : Callback<MovieDetail?> {
            override fun onFailure(call: Call<MovieDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieDetail?>, response: Response<MovieDetail?>) {
                movie.value = response.body()
            }
        })

        return movie
    }

    //detail tv
    fun fetchDataTvDetail(tvId: String?) : MutableLiveData<TVShowDetail>? {
        val tvShow = MutableLiveData<TVShowDetail>()
        val call = placeHolderApi.getTVShowDetail(tvId, BuildConfig.API_V3_KEY)
        call.enqueue(object : Callback<TVShowDetail?> {
            override fun onFailure(call: Call<TVShowDetail?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TVShowDetail?>, response: Response<TVShowDetail?>) {
                tvShow.value = response.body()
            }
        })

        return tvShow
    }
}