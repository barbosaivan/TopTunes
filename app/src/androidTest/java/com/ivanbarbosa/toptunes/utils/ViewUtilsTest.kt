package com.ivanbarbosa.toptunes.utils

import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.ivanbarbosa.toptunes.entities.artists.Artist
import com.ivanbarbosa.toptunes.entities.artists.AttrTopArtist
import com.ivanbarbosa.toptunes.entities.artists.TopArtists
import com.ivanbarbosa.toptunes.entities.tracks.ApiResponseTrack
import com.ivanbarbosa.toptunes.entities.tracks.AttrTopTrack
import com.ivanbarbosa.toptunes.entities.tracks.TopTracksArtist
import com.ivanbarbosa.toptunes.entities.tracks.Track
import kotlinx.coroutines.launch
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.utils
* Create by Ivan Barbosa on 18/09/2023 at 1:45 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
    return RecyclerViewMatcher(recyclerViewId)
}

class RecyclerViewMatcher(private val recyclerViewId: Int) {

    fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> {
        return ChildViewMatcher(position, targetViewId)
    }

    private inner class ChildViewMatcher(private val position: Int, private val targetViewId: Int) :
        TypeSafeMatcher<View>() {

        override fun describeTo(description: Description) {
            description.appendText("ChildViewMatcher(position: $position, targetViewId: $targetViewId)")
        }

        override fun matchesSafely(item: View): Boolean {
            val recyclerView = item.rootView?.findViewById(recyclerViewId) as RecyclerView
            val targetView =
                recyclerView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<View>(
                    targetViewId
                )
            return targetView == item
        }
    }
}

fun getTextFromView(viewMatcher: ViewInteraction): String {
    var text: String? = null
    viewMatcher.perform(
        ViewActions.actionWithAssertions(
            ViewActions.actionWithAssertions(
                ViewActions.actionWithAssertions(object : ViewAction {
                    override fun getConstraints(): Matcher<View> {
                        return ViewMatchers.isAssignableFrom(TextView::class.java)
                    }

                    override fun getDescription(): String {
                        return "getting text from TextView"
                    }

                    override fun perform(uiController: UiController?, view: View?) {
                        val textView = view as TextView
                        text = textView.text.toString()
                    }
                })
            )
        )
    )
    return text ?: ""
}
