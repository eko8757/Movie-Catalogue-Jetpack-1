package com.jetpack.moviecataloguejetpack.viewmodel

import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.model.MovieModel
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class MovieViewModelTest {
    private var viewModel: MovieViewModel? = null
    private var data: MovieModel? = null

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        data = MovieModel(
            1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            R.drawable.movie_a_start_is_born,
            "October 3, 2018",
            "75",
            "https://youtu.be/nSbzyEJ8X9E"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getResult() {
        assertEquals(19, viewModel?.movies?.size)
        assertEquals(data?.movieId, viewModel?.movieDetail(1)?.movieId)
        assertEquals(data?.movieTitle, viewModel?.movieDetail(1)?.movieTitle)
        assertEquals(data?.movieDescription, viewModel?.movieDetail(1)?.movieDescription)
        assertEquals(data?.moviePoster, viewModel?.movieDetail(1)?.moviePoster)
        assertEquals(data?.movieRating, viewModel?.movieDetail(1)?.movieRating)
        assertEquals(data?.movieRelease, viewModel?.movieDetail(1)?.movieRelease)
    }
}