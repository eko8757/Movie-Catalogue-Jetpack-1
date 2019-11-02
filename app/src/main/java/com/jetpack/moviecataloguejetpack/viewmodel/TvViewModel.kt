package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.jetpack.moviecataloguejetpack.model.DataDummy
import com.jetpack.moviecataloguejetpack.model.TvModel

class TvViewModel: ViewModel() {
    val tvShow: List<TvModel> = DataDummy.generateTvShow()
    fun tvShowDetail(id: Int): TvModel? = DataDummy.tvShowDetail(id)
}