package com.jetpack.moviecataloguejetpack.view.fragment.favorite

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jetpack.moviecataloguejetpack.R

class MovieFavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_favorite, container, false)
    }

    companion object {
        fun movieInstance() : MovieFavoriteFragment = MovieFavoriteFragment()
    }

}
