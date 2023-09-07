package com.ivanbarbosa.toptunes.viewModel

import com.ivanbarbosa.toptunes.entities.Image
import com.ivanbarbosa.toptunes.entities.tracks.AttrSong
import com.ivanbarbosa.toptunes.entities.tracks.AttrTopTrack
import com.ivanbarbosa.toptunes.entities.tracks.TopTracksArtist
import com.ivanbarbosa.toptunes.entities.tracks.Track

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.viewModel
* Create by Ivan Barbosa on 1/09/2023 at 12:50 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

fun fakeTopTracksArtist(): TopTracksArtist{
    val imageList = listOf(
        Image("http://example.com/image1.jpg", "medium"),
        Image("http://example.com/image2.jpg", "large")
    )

    val trackList = listOf(
        Track("Song 1", 1000, 500, "http://example.com/song1", imageList, AttrSong(1)),
        Track("Song 2", 750, 400, "http://example.com/song2", imageList, AttrSong(2))
    )

    return TopTracksArtist(trackList, AttrTopTrack("cher", "1", "10", "5", "50"))
}

fun fakeTopTracksArtistEmpty(): TopTracksArtist{
    val trackList = emptyList<Track>()
    return TopTracksArtist(trackList, AttrTopTrack("", "", "", "", ""))
}