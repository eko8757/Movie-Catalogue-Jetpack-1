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
import com.jetpack.moviecataloguejetpack.model.entity.TvModel
import com.jetpack.moviecataloguejetpack.view.activity.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

class TvAdapter(private val context: Context) : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private var tvList: MutableList<TvModel>? = null

    fun setupTvList(tvShow: MutableList<TvModel>?) {
        tvList = tvShow
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return if (tvList != null) {
            tvList!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = tvList?.get(position)
        if (tv != null) {
            holder.bindData(tv)
        }
    }

    inner class TvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.tv_title
        private val desc = view.tv_desc
        private val poster = view.img_card

        fun bindData(listTv: TvModel) {
            title.text = listTv.originalName
            desc.text = listTv.overview
            Glide.with(context).load(BuildConfig.URL_IMG_APP + listTv.posterPath).into(poster)

            itemView.setOnClickListener {
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra("dataType", "TV_SHOW")
                        .putExtra("tvShowID", listTv.idTVShow)
                )
            }
        }
    }
}