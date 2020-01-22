package com.jetpack.moviecataloguejetpack.model.entity.tv

import com.google.gson.annotations.SerializedName

data class TvData(
    @SerializedName("results")
    val tvList: MutableList<TvModel>?
)