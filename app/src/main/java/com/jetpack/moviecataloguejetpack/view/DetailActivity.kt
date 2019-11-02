package com.jetpack.moviecataloguejetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.MovieModel
import com.jetpack.moviecataloguejetpack.model.TvModel
import com.jetpack.moviecataloguejetpack.viewmodel.MovieViewModel
import com.jetpack.moviecataloguejetpack.viewmodel.TvViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent.getIntExtra("movieId", 0) != 0) {
            loadDataMovie(movieViewModel.movieDetail(intent.getIntExtra("movieId", 0)))
        } else {
            loadDataTv(tvShowViewModel.tvShowDetail(intent.getIntExtra("tvId", 0)))
        }
    }

    private fun loadDataMovie(movie: MovieModel?) {
        Glide.with(this).load(movie?.moviePoster).into(img_detail)
        Glide.with(this).load(movie?.moviePoster).transform(RoundedCorners(8)).into(img_detail)
        tv_title_detail.text = movie?.movieTitle
        tv_release_date.text = movie?.movieRelease
        tv_vote_average.text = movie?.movieRating
        tv_desc_detail.text = movie?.movieDescription
    }

    private fun loadDataTv(tv: TvModel?) {
        Glide.with(this).load(tv?.tvShowPoster).into(img_detail)
        Glide.with(this).load(tv?.tvShowPoster).transform(RoundedCorners(8)).into(img_detail)
        tv_title_detail.text = tv?.tvShowTitle
        tv_release_date.text = tv?.tvShowRelease
        tv_vote_average.text = tv?.tvShowRating
        tv_desc_detail.text = tv?.tvShowDescription
    }

    private val movieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this).get(TvViewModel::class.java)
    }
}
