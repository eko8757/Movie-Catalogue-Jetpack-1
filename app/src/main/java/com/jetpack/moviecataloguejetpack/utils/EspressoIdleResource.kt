package com.jetpack.moviecataloguejetpack.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdleResource {
    private const val RESOURCE = "GLOBAL"
    private val espressoTestIdleResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdleResource.increment()
    }

    fun decrement() {
        espressoTestIdleResource.decrement()
    }

    fun getEspressoIdleResource() : IdlingResource {
        return espressoTestIdleResource
    }
}