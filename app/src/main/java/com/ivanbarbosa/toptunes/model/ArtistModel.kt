package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.entities.tracks.ApiResponseTrack

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.model
* Create by Ivan Barbosa on 16/06/2023 at 1:44 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/class ArtistModel {
    private val requestApi = RequestApi()

    suspend fun getTopTrack(
        method: String,
        artist: String,
        apiKey: String,
        format: String
    ): ApiResponseTrack = requestApi.getTopTracks(method, artist, apiKey, format)
}