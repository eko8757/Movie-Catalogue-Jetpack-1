package com.jetpack.moviecataloguejetpack.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.jetpack.moviecataloguejetpack.BuildConfig
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.utils.EspressoIdleResource
import com.jetpack.moviecataloguejetpack.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        shimmerFrameLayout = detail_shimer
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
            Log.d("DetailActivity", movieId)
            EspressoIdleResource.increment()
            viewModel.getMovieDetailData(movieId)?.observe(this, Observer { movieDetails ->
                if (movieDetails != null) {
                    title.text = movieDetails.title
                    releaseDate.text = movieDetails.releaseDate
                    voteAverage.text = movieDetails.voteAverage.toString()
                    desc.text = movieDetails.overview
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + movieDetails.posterPath).into(imageDetail)
                }
                shimmerFrameLayout.hideShimmer()

                if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()

            })
        } else {
            Log.d("DetailActivity", tvId)
            EspressoIdleResource.increment()
            viewModel.getTVDetailData(tvId)?.observe(this, Observer { tvDetails ->
                if (tvDetails != null) {
                    title.text = tvDetails.title
                    releaseDate.text = tvDetails.firstAirDate
                    voteAverage.text = tvDetails.voteAverage.toString()
                    desc.text = tvDetails.overview
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + tvDetails.posterPath).into(imageDetail)
                }
                shimmerFrameLayout.hideShimmer()

                if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()
            })
        }
    }

}
