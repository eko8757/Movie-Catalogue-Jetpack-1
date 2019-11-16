package com.jetpack.moviecataloguejetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.MovieAdapter
import com.jetpack.moviecataloguejetpack.model.MovieModel
import com.jetpack.moviecataloguejetpack.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var movieList: List<MovieModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private val movieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    private val movieAdapter by lazy {
        MovieAdapter(context, movieList)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieList = movieViewModel.movies
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MovieFragment.movieAdapter
        }
    }

    companion object {
        fun movieInstance() : MovieFragment = MovieFragment()
    }
}
