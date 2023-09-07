package com.ivanbarbosa.toptunes.entities.artists

import com.google.gson.annotations.SerializedName

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.enity
* Create by Ivan Barbosa on 15/06/2023 at 8:00 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
data class TopArtists(
    val artist: List<Artist>,
    @SerializedName("@attr")val attr: AttrTopArtist
)
