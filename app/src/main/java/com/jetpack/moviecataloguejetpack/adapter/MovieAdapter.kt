package com.jetpack.moviecataloguejetpack.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.moviecataloguejetpack.BuildConfig
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.view.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList : MutableList<MovieModel>? = null

    fun setupMovieList(movies : MutableList<MovieModel>?) {
        movieList = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return if (movieList != null) {
            movieList!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList?.get(position)
        if (movie != null) {
            holder.bindData(movie)
        }
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.tv_title
        private val desc = view.tv_desc
        private val poster = view.img_card

        fun bindData(listMovies: MovieModel) {
            title.text = listMovies.title
            desc.text = listMovies.overview
            Glide.with(context).load(BuildConfig.URL_IMG_APP + listMovies.posterPath).into(poster)

            itemView.setOnClickListener {
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra("dataType", "MOVIE")
                        .putExtra("movieID", listMovies.idMovie)
                )
            }
        }
    }
}