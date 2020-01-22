package com.jetpack.moviecataloguejetpack.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.jetpack.moviecataloguejetpack.BuildConfig
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.entity.movie.MovieDetail
import com.jetpack.moviecataloguejetpack.model.entity.tv.TVShowDetail
import com.jetpack.moviecataloguejetpack.utils.EspressoIdleResource
import com.jetpack.moviecataloguejetpack.viewmodel.DetailViewModel
import com.jetpack.moviecataloguejetpack.viewmodel.FavoriteViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    private lateinit var favoriteViewModel: FavoriteViewModel
    private var movieDetail: MovieDetail? = null
    private var tvDetail: TVShowDetail? = null
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private var type: String? = null
    private val TYPE_MOVIE = "MOVIE"
    private val TYPE_TV = "TV_SHOW"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        shimmerFrameLayout = detail_shimer
        val movieId: String? = intent.getStringExtra("movieID")
        val tvId: String? = intent.getStringExtra("tvShowID")
        type = intent.getStringExtra("dataType")
        val title: TextView = findViewById(R.id.tv_title_detail)
        val releaseDate: TextView = findViewById(R.id.tv_release_date)
        val voteAverage: TextView = findViewById(R.id.tv_vote_average)
        val desc: TextView = findViewById(R.id.tv_desc_detail)
        val imageDetail: ImageView = findViewById(R.id.img_detail)
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
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + movieDetails.posterPath)
                        .into(imageDetail)
                }
                shimmerFrameLayout.hideShimmer()

                if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()
            })

            if (movieId != null) {
                checkFavorite(movieId)
            }

        } else {
            Log.d("DetailActivity", tvId)
            EspressoIdleResource.increment()
            viewModel.getTVDetailData(tvId)?.observe(this, Observer { tvDetails ->
                if (tvDetails != null) {
                    title.text = tvDetails.title
                    releaseDate.text = tvDetails.firstAirDate
                    voteAverage.text = tvDetails.voteAverage.toString()
                    desc.text = tvDetails.overview
                    Glide.with(this).load(BuildConfig.URL_IMG_APP + tvDetails.posterPath)
                        .into(imageDetail)
                }
                shimmerFrameLayout.hideShimmer()

                if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()
            })

            if (tvId != null) {
                checkFavorite(tvId)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.action_favorite -> {
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setFavorite() {
        if (isFavorite) {
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
        } else {
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
        }
    }

    //remove data
    private fun removeFromFavorite() {
        when (type) {
            TYPE_MOVIE -> {
                favoriteViewModel.removeFavoriteMovieData(movieDetail!!)
                isFavorite = true
                setFavorite()
            }

            TYPE_TV ->  {
                favoriteViewModel.removeFavoriteTvData(tvDetail!!)
                isFavorite = true
                setFavorite()
            }
        }
    }

    //insert data
    private fun addToFavorite() {
        when (type) {
            TYPE_MOVIE -> {
                favoriteViewModel.insertFavoriteMovieData(movieDetail!!)
                isFavorite = true
                setFavorite()
            }

            TYPE_TV -> {
                favoriteViewModel.insertFavoriteTvData(tvDetail!!)
                isFavorite = true
                setFavorite()
            }
        }
    }

    //check is favorite
    private fun checkFavorite(data: String) {
        when(type) {
            TYPE_MOVIE -> {
                favoriteViewModel.checkIsMovieFavorite(data)?.observe(this, Observer { dataLiveData ->
                    if (dataLiveData != null) {
                        isFavorite = true
                        setFavorite()
                    }
                })
            }

            TYPE_TV -> {
                favoriteViewModel.checkIsTvFavorite(data)?.observe(this, Observer { dataLiveData ->
                    if (dataLiveData != null) {
                        isFavorite = true
                        setFavorite()
                    }
                })
            }
        }
    }

}
