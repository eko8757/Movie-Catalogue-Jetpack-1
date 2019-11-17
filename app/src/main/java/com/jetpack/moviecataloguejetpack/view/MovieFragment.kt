package com.jetpack.moviecataloguejetpack.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.MovieAdapter
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.utils.EspressoIdleResource
import com.jetpack.moviecataloguejetpack.utils.invisible
import com.jetpack.moviecataloguejetpack.utils.visible
import com.jetpack.moviecataloguejetpack.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_movie)
        progressBar = view.findViewById(R.id.progress_movie)
        swipeRefreshLayout = view.findViewById(R.id.swipe_movie)

        progressBar.visible()

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val adapter = MovieAdapter(activity!!)
        recyclerView.layoutManager = LinearLayoutManager(activity!!)
        recyclerView.adapter = adapter

        observeData(viewModel, adapter)
        swipeRefreshLayout.setOnRefreshListener {
            observeData(viewModel, adapter)
        }
    }

    private fun observeData(viewModel: MainViewModel, adapter: MovieAdapter) {
        EspressoIdleResource.increment()
        viewModel.getMovieList()?.observe(this, Observer<MutableList<MovieModel>> {
            if (it != null) {
                adapter.setupMovieList(it)
            } else {
                Log.e("MovieFragment", "NULL")
            }

            progressBar.invisible()
            if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()
            swipeRefreshLayout.isRefreshing = false
        })
    }
}
