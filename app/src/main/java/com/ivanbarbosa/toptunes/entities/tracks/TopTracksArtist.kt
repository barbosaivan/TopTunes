package com.ivanbarbosa.toptunes.entities.tracks

import com.google.gson.annotations.SerializedName

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.enity
* Create by Ivan Barbosa on 16/06/2023 at 1:27 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
data class TopTracksArtist(
    val track: List<Track>,
    @SerializedName("@attr") val attr: AttrTopTrack
)
