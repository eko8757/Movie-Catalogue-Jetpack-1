package com.jetpack.moviecataloguejetpack.viewmodel

import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.TvModel
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class TvViewModelTest {
    private var viewModel: TvViewModel? = null
    private var data: TvModel? = null

    @Before
    fun setUp() {
        viewModel = TvViewModel()
        data = TvModel(
            1,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            R.drawable.tvshow_arrow,
            "October 10, 2012",
            "58",
            "https://youtu.be/hTv13EjlLNg"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getResult() {
        assertEquals(20, viewModel?.tvShow?.size)
        assertEquals(data?.tvShowId, viewModel?.tvShowDetail(1)?.tvShowId)
        assertEquals(data?.tvShowTitle, viewModel?.tvShowDetail(1)?.tvShowTitle)
        assertEquals(data?.tvShowDescription, viewModel?.tvShowDetail(1)?.tvShowDescription)
        assertEquals(data?.tvShowPoster, viewModel?.tvShowDetail(1)?.tvShowPoster)
        assertEquals(data?.tvShowRating, viewModel?.tvShowDetail(1)?.tvShowRating)
        assertEquals(data?.tvShowRelease, viewModel?.tvShowDetail(1)?.tvShowRelease)
    }
}