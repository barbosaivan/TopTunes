package com.ivanbarbosa.toptunes.enities.tracks

import com.google.gson.annotations.SerializedName
import com.ivanbarbosa.toptunes.enities.Image

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.enity
* Create by Ivan Barbosa on 16/06/2023 at 1:18 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/data class Track(
    val name: String,
    val playcount: Int,
    val listeners: Int,
    val url: String,
    val image: List<Image>,
    @SerializedName ("@attr") val attr: AttrSong

)
