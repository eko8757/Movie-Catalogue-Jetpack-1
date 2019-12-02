package com.jetpack.moviecataloguejetpack.view.fragment.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jetpack.moviecataloguejetpack.R

/**
 * A simple [Fragment] subclass.
 */
class TvFavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_favorite, container, false)
    }

    companion object {
        fun tvInstance() : TvFavoriteFragment = TvFavoriteFragment()
    }

}
