package com.ivanbarbosa.toptunes.view

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.*
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ivanbarbosa.toptunes.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.view
* Create by Ivan Barbosa on 20/09/2023 at 7:50 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class ArtistActivityTest {

    @get:Rule
    val activityRule2 = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun testArtistDetailsDisplayed() {

        Thread.sleep(2000)
        val recyclerViewArtist = onView(withId(R.id.recycler_artists))
        recyclerViewArtist.check(matches(isDisplayed()))
        recyclerViewArtist.check(matches(hasMinimumChildCount(1)))
        recyclerViewArtist.perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        Thread.sleep(2000)
        onView(withId(R.id.image_artist)).check(matches(isDisplayed()))
        onView(withId(R.id.name_artists_by_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_see)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_tracks)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_see)).perform(click())
        intended(hasAction(Intent.ACTION_VIEW))
    }

    @Test
    fun testArtistSongsDisplayed() {

        Thread.sleep(2000)
        val recyclerViewArtist = onView(withId(R.id.recycler_artists))
        recyclerViewArtist.check(matches(isDisplayed()))
        recyclerViewArtist.check(matches(hasMinimumChildCount(1)))
        recyclerViewArtist.perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        Thread.sleep(2000)
        val recyclerViewTracks = onView(withId(R.id.recycler_tracks))
        recyclerViewTracks.check(matches(isDisplayed()))
        recyclerViewTracks.check(matches(hasMinimumChildCount(1)))
        recyclerViewTracks.perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        intended(hasAction(Intent.ACTION_VIEW))
    }
}