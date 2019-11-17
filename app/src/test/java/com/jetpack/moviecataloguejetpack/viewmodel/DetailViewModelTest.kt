package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jetpack.moviecataloguejetpack.repositories.MainRepositories
import com.jetpack.moviecataloguejetpack.utils.getOrAwaitValue
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class DetailViewModelTest {

    @get: Rule
    val instanTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailViewModel: DetailViewModel

    @Mock
    private lateinit var mainRepositories: MainRepositories

    @Before
    fun setUp() {
        mainRepositories = Mockito.mock(MainRepositories::class.java)
        detailViewModel = DetailViewModel()
    }

    @Test
    fun getMovieDetail() {
        val movieIndex = "475557"
        val expectedTitle = "Joker"
        detailViewModel.getMovieDetailData(movieIndex)
        Assert.assertEquals(expectedTitle, detailViewModel.getMovieDetailData(movieIndex)?.getOrAwaitValue()?.title)
    }

    @Test
    fun getTvShowDetail() {
        val tvIndex = "60625"
        val expectedName = "Rick and Morty"
        detailViewModel.getTVDetailData(tvIndex)
        Assert.assertEquals(expectedName, detailViewModel.getTVDetailData(tvIndex)?.getOrAwaitValue()?.title)
    }
}