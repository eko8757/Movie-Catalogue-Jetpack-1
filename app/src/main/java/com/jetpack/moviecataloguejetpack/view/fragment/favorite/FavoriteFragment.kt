package com.jetpack.moviecataloguejetpack.view.fragment.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.PagerAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(viewPager_favorite)
        tab_favorite.setupWithViewPager(viewPager_favorite)

    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = fragmentManager?.let {
            PagerAdapter(it)
        }

        val movie = MovieFavoriteFragment.movieInstance()
        adapter?.addFragment(movie, "Movie")
        val tv = TvFavoriteFragment.tvInstance()
        adapter?.addFragment(tv, "Tv Show")
        pager.adapter = adapter
    }


}
