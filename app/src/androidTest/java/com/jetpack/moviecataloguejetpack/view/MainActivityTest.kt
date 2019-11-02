package com.jetpack.moviecataloguejetpack.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.jetpack.moviecataloguejetpack.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppBehaviour() {
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.nav_view)).check(ViewAssertions.matches(isDisplayed()))

        //movie fragment
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.navigation_movie)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.navigation_movie)).perform(click())

        Thread.sleep(3000)
        Espresso.onView(withId(R.id.rv_movie)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

        Thread.sleep(1000)
        Espresso.pressBack()

        Thread.sleep(3000)
        Espresso.onView(withId(R.id.rv_movie)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))

        Thread.sleep(1000)
        Espresso.pressBack()

        //tv fragment
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.navigation_tv)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.navigation_tv)).perform(click())

        Thread.sleep(3000)
        Espresso.onView(withId(R.id.rv_tv)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

        Thread.sleep(1000)
        Espresso.pressBack()

        Thread.sleep(3000)
        Espresso.onView(withId(R.id.rv_tv)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))

        Thread.sleep(1000)
        Espresso.pressBack()
    }
}