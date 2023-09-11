package com.ivanbarbosa.toptunes

import com.ivanbarbosa.toptunes.entities.Image
import com.ivanbarbosa.toptunes.entities.artists.Artist
import com.ivanbarbosa.toptunes.entities.artists.AttrTopArtist
import com.ivanbarbosa.toptunes.entities.artists.TopArtists

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes
* Create by Ivan Barbosa on 11/09/2023 at 11:59 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
fun fakeTopArtist(): TopArtists {
    val imageList = listOf(
        Image("http://example.com/image1.jpg", "medium"),
        Image("http://example.com/image2.jpg", "large")
    )

    val artistList = listOf(
        Artist("Song 1", 1000, "http://example.com/song1", imageList),
        Artist("Song 2", 750, "http://example.com/song2", imageList)
    )

    return TopArtists(artistList, AttrTopArtist("Colombia", "1", "10", "5", "50"))
}

fun fakeTopArtistEmpty(): TopArtists {
    val artistList = emptyList<Artist>()
    return TopArtists(artistList, AttrTopArtist("", "", "", "", ""))
}