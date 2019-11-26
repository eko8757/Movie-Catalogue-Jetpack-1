package com.jetpack.moviecataloguejetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpack.moviecataloguejetpack.model.entity.MovieModel
import com.jetpack.moviecataloguejetpack.model.entity.TvModel
import com.jetpack.moviecataloguejetpack.repositories.MainRepositories
import com.jetpack.moviecataloguejetpack.utils.getOrAwaitValue
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import java.math.BigInteger

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
        val mainViewModel = Mockito.mock(MainViewModel::class.java)
        val dummyMovie = MovieModel(
            "475557",
            "Joker",
            "2019-10-02",
            8.4,
            "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg"
        )

        val movieDummy: MutableLiveData<MutableList<MovieModel>> = MutableLiveData()
        val movieDummyList: MutableList<MovieModel> = mutableListOf()

        for (i in 0..15) movieDummyList.add(dummyMovie)
        movieDummy.value = movieDummyList
        `when`(mainViewModel.getMovieList()).thenReturn(movieDummy)

        val observer: Observer<MutableList<MovieModel>> = Mockito.mock(Observer::class.java) as Observer<MutableList<MovieModel>>
        mainViewModel.getMovieList()?.observeForever(observer)
        verify(observer).onChanged(movieDummyList)
    }

    @Test
    fun getTvShowList() {
        val mainViewModel = Mockito.mock(MainViewModel::class.java)
        val dummyTv = TvModel(
            "71712",
            "The Good Doctor",
            "2017-09-25",
            7.7,
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
            "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg"
        )

        val tvDummy: MutableLiveData<MutableList<TvModel>> = MutableLiveData()
        val tvDummyList: MutableList<TvModel> = mutableListOf()

        for (i in 0..15) tvDummyList.add(dummyTv)
        tvDummy.value = tvDummyList
        `when`(mainViewModel.getTvList()).thenReturn(tvDummy)

        val observer: Observer<MutableList<TvModel>> = Mockito.mock(Observer::class.java) as Observer<MutableList<TvModel>>
        mainViewModel.getTvList()?.observeForever(observer)
        verify(observer).onChanged(tvDummyList)
    }
}