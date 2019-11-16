package com.jetpack.moviecataloguejetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.jetpack.moviecataloguejetpack.BuildConfig
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movieId: String? = intent.getStringExtra("movieID")
        val tvId: String? = intent.getStringExtra("tvShowID")
        val type = intent.getStringExtra("dataType")
        val title : TextView = findViewById(R.id.tv_title_detail)
        val releaseDate: TextView = findViewById(R.id.tv_release_date)
        val voteAverage: TextView = findViewById(R.id.tv_vote_average)
        val desc:TextView = findViewById(R.id.tv_desc_detail)
        val imageDetail:ImageView = findViewById(R.id.img_detail)
        val viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        if (type == "MOVIE") {
            Log.d("DetailACtivity", movieId)
            viewModel.getMovieDetailData(movieId)?.observe(this, Observer { movieDetails ->
                if (movieDetails != null) {
                    title.text = movieDetails.title
                    releaseDate.text = movieDetails.releaseDate
                    voteAverage.text = movieDetails.voteAverage.toString()
                    desc.text = movieDetails.overview
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + movieDetails.posterPath).into(imageDetail)
                }

            })
        } else {
            Log.d("DetailActivity", tvId)
            viewModel.getTVDetailData(tvId)?.observe(this, Observer { tvDetails ->
                if (tvDetails != null) {
                    title.text = tvDetails.title
                    releaseDate.text = tvDetails.firstAirDate
                    voteAverage.text = tvDetails.voteAverage.toString()
                    desc.text = tvDetails.overview
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + tvDetails.posterPath).into(imageDetail)
                }
            })
        }
    }

}
