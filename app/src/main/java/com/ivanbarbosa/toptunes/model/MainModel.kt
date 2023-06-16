package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.enities.artists.ApiResponseArtist

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes
* Create by Ivan Barbosa on 15/06/2023 at 4:27 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class MainModel {
    private val requestApi = RequestApi()

    suspend fun getTopArtist(
        method: String,
        country: String,
        apiKey: String,
        format: String
    ): ApiResponseArtist = requestApi.getTopArtist(method, country, apiKey, format)
}