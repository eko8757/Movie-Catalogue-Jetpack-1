package com.jetpack.moviecataloguejetpack.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.TvModel
import com.jetpack.moviecataloguejetpack.view.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

class TvAdapter(private val context: Context?, private val listTv: List<TvModel>)
    : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = listTv.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bindData(listTv[position])
        context?.let { Glide.with(it).load(listTv[position].tvShowPoster).into(holder.poster) }
        holder.cardItem.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("tvId", listTv[position].tvShowId)
            context?.startActivity(i)
        }
    }

    class TvViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster = view.img_card
        val cardItem = view.cv_item

        fun bindData(listTv: TvModel) {
            itemView.tv_title.text = listTv.tvShowTitle
            itemView.tv_desc.text = listTv.tvShowDescription
        }
    }
}