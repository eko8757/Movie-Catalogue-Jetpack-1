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

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var mainRepositories: MainRepositories

    @Before
    fun setUp() {
        mainRepositories = Mockito.mock(MainRepositories::class.java)
        mainViewModel = MainViewModel()
    }

    @Test
    fun getMovieList() {
        val expectedSize = 10
        Assert.assertTrue("MovieList Data", mainViewModel.getMovieList()?.getOrAwaitValue()?.size ?: 0 > expectedSize)
    }

    @Test
    fun getTvShowList() {
        val expectedSize = 10
        Assert.assertTrue("TvShowList Data", mainViewModel.getTvList()?.getOrAwaitValue()?.size ?: 0 > expectedSize)
    }
}