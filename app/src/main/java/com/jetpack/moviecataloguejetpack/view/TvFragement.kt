package com.jetpack.moviecataloguejetpack.view

import android.os.Bundle
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
import com.jetpack.moviecataloguejetpack.adapter.TvAdapter
import com.jetpack.moviecataloguejetpack.model.entity.TvModel
import com.jetpack.moviecataloguejetpack.utils.EspressoIdleResource
import com.jetpack.moviecataloguejetpack.utils.invisible
import com.jetpack.moviecataloguejetpack.utils.visible
import com.jetpack.moviecataloguejetpack.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class TvFragement : Fragment() {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_tv)
        progressBar = view.findViewById(R.id.progress_tv)
        swipeRefreshLayout = view.findViewById(R.id.swipe_tv)

        progressBar.visible()

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val adapter = TvAdapter(activity!!)
        recyclerView.layoutManager = LinearLayoutManager(activity!!)
        recyclerView.adapter = adapter

        observeData(viewModel, adapter)
        swipeRefreshLayout.setOnRefreshListener {
            observeData(viewModel, adapter)
        }
    }

    private fun observeData(viewModel: MainViewModel, adapter: TvAdapter) {
        EspressoIdleResource.increment()
        viewModel.getTvList()?.observe(this, Observer<MutableList<TvModel>> {
            if (it != null) {
                adapter.setupTvList(it)
            }
            progressBar.invisible()
            if (!EspressoIdleResource.getEspressoIdleResource().isIdleNow) EspressoIdleResource.decrement()
            swipeRefreshLayout.isRefreshing = false
        })
    }
}
