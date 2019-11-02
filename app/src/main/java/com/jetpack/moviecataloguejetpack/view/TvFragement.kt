package com.jetpack.moviecataloguejetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.TvAdapter
import com.jetpack.moviecataloguejetpack.model.TvModel
import com.jetpack.moviecataloguejetpack.viewmodel.TvViewModel
import kotlinx.android.synthetic.main.fragment_tv.*

/**
 * A simple [Fragment] subclass.
 */
class TvFragement : Fragment() {

    lateinit var tvShowList: List<TvModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    private val tvShowViewModel  by lazy {
        ViewModelProviders.of(this).get(TvViewModel::class.java)
    }

    private val tvShowAdapter by lazy {
        TvAdapter(context, tvShowList)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvShowList = tvShowViewModel.tvShow
        rv_tv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TvFragement.tvShowAdapter
        }
    }
}
