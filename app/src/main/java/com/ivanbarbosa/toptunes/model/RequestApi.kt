package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.dataAccess.ApiService
import com.ivanbarbosa.toptunes.enity.ApiResponseArtist
import com.ivanbarbosa.toptunes.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.model
* Create by Ivan Barbosa on 15/06/2023 at 6:14 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class RequestApi {

    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(ApiService::class.java)

    suspend fun getTopArtist(
        method: String,
        country: String,
        apiKey: String,
        format: String
    ): ApiResponseArtist = withContext(Dispatchers.IO) {
        service.getArtist(method, country, apiKey, format)
    }
}