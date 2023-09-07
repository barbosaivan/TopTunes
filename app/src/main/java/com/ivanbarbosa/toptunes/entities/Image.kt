package com.ivanbarbosa.toptunes.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/*
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.enity
* Create by Ivan Barbosa on 15/06/2023 at 4:34 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

data class Image(
    @SerializedName("#text") val text: String,
    val size: String
): Serializable
