package com.ivanbarbosa.toptunes.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.utils.getTextFromView
import com.ivanbarbosa.toptunes.utils.withRecyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.view
* Create by Ivan Barbosa on 12/09/2023 at 12:25 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testArtistListIsDisplayed() {
        // Espera un tiempo para que los datos se carguen
        Thread.sleep(2000)

        val recyclerViewArtist = onView(withId(R.id.recycler_artists))

        // Verifica que el RecyclerView esté visible y que al menos un elemento esté presente
        recyclerViewArtist.check(matches(isDisplayed()))
        recyclerViewArtist.check(matches(hasMinimumChildCount(1)))

        // Obtiene el nombre del primer artista de la lista
        val artistName = getTextFromView(
            onView(
                withRecyclerView(R.id.recycler_artists)
                    .atPositionOnView(0, R.id.name_artist)
            )
        )

        // Haz clic en el primer elemento de la lista
        recyclerViewArtist.perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Espera un tiempo para que los datos se carguen
        Thread.sleep(2000)

        //Valida que la nueva vista se lanzo
        onView(withId(R.id.activity_artist)).check(matches(isDisplayed()))

        // Verificar el nombre del artista en la vista de detalle
        onView(withId(R.id.name_artists_by_detail)).check(matches(withText(artistName)))
    }
}