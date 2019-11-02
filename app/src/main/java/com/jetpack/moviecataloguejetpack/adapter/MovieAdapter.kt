package com.jetpack.moviecataloguejetpack.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.MovieModel
import com.jetpack.moviecataloguejetpack.view.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

class MovieAdapter(private val context: Context?, private val listMovies: List<MovieModel>)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(listMovies[position])
        context?.let { Glide.with(it).load(listMovies[position].moviePoster).into(holder.poster) }
        holder.cardItem.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("movieId", listMovies[position].movieId)
            context?.startActivity(i)
        }
    }


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster = view.img_card
        val cardItem = view.cv_item

        fun bindData(listMovies: MovieModel) {
            itemView.tv_title.text = listMovies.movieTitle
            itemView.tv_desc.text = listMovies.movieDescription
        }
    }
}