package com.jetpack.moviecataloguejetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.PagerAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(viewPager_main)
        tab_main.setupWithViewPager(viewPager_main)
    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = fragmentManager?.let {
            PagerAdapter(it)
        }
        val movie = MovieFragment.movieInstance()
        adapter?.addFragment(movie, "Movie")
        val tv = TvFragement.tvInstance()
        adapter?.addFragment(tv, "TvShow")
        pager.adapter = adapter

    }


}
