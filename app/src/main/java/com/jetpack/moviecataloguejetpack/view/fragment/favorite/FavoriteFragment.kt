package com.jetpack.moviecataloguejetpack.view.fragment.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.PagerAdapter
import com.jetpack.moviecataloguejetpack.view.fragment.MovieFragment
import com.jetpack.moviecataloguejetpack.view.fragment.TvFragement

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_favorite, container, false)
        val adapter = PagerAdapter(activity!!.supportFragmentManager)
        val viewPager = rootView.findViewById<ViewPager>(R.id.viewPager_favorite)
        val tab = rootView.findViewById<TabLayout>(R.id.tab_favorite)

        //set view pager & tab layout
        adapter.addFragment(FavoriteMovieFragment(), "Movies")
        adapter.addFragment(FavoriteTvFragment(), "Tv Show")
        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)
        return rootView
    }

}
