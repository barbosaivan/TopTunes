package com.ivanbarbosa.toptunes.enity

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes
* Create by Ivan Barbosa on 15/06/2023 at 4:29 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
data class Artist(
    val name: String, val listeners:
    Int, val url: String,
    val image: List<Image>
)
