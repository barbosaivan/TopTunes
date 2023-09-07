package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.dataAccess.ApiService
import com.ivanbarbosa.toptunes.entities.artists.ApiResponseArtist
import com.ivanbarbosa.toptunes.entities.tracks.ApiResponseTrack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.model
* Create by Ivan Barbosa on 15/06/2023 at 6:14 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class RequestApi @Inject constructor(private val service: ApiService) {
    suspend fun getTopArtist(
        method: String,
        country: String,
        apiKey: String,
        format: String
    ): ApiResponseArtist = withContext(Dispatchers.IO) {
        service.getArtist(method, country, apiKey, format)
    }

    suspend fun getTopTracks(
        method: String,
        artist: String,
        apiKey: String,
        format: String
    ): ApiResponseTrack = withContext(Dispatchers.IO) {
        service.getTrack(method, artist, apiKey, format)
    }
}