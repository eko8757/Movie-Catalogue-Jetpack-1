package com.jetpack.moviecataloguejetpack.view

import android.os.SystemClock
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.adapter.MovieAdapter
import com.jetpack.moviecataloguejetpack.adapter.TvAdapter
import com.jetpack.moviecataloguejetpack.utils.EspressoIdleResource
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mainAcrivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdleResource.getEspressoIdleResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().register(EspressoIdleResource.getEspressoIdleResource())
    }

    @Test
    fun testTvViews() {
        Espresso.onView(ViewMatchers.withId(R.id.viewPager_main)).perform(ViewActions.swipeLeft())
    }

    @Test
    fun testMovieViews() {
        Espresso.onView(ViewMatchers.withId(R.id.viewPager_main)).perform(ViewActions.swipeLeft())
        val matcher = allOf(ViewMatchers.withText("MOVIE"), ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tab_main)))
        Espresso.onView(matcher).perform(ViewActions.click())
        SystemClock.sleep(800)
    }

    @Test
    fun testRecyclerMovieBehaviour() {
        Espresso.onView(allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.rv_movie)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MovieViewHolder>(0, ViewActions.click()))
        Thread.sleep(3000)

        Espresso.pressBack()
        Thread.sleep(3000)
    }

    @Test
    fun testRecyclerTvBehaviour() {
        val matcher = allOf(ViewMatchers.withText("TV SHOW"), ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tab_main)))
        Espresso.onView(matcher).perform(ViewActions.click())

        Espresso.onView(allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.rv_tv)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TvAdapter.TvViewHolder>(4, ViewActions.click()))
        Thread.sleep(3000)

        Espresso.pressBack()
        Thread.sleep(3000)
    }
}