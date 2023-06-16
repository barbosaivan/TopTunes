package com.ivanbarbosa.toptunes.dataAccess

import com.ivanbarbosa.toptunes.enity.ApiResponseArtist
import com.ivanbarbosa.toptunes.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.dataAccess
* Create by Ivan Barbosa on 15/06/2023 at 5:26 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
interface ApiService {

    @GET(Constants.BASE_URL)
    suspend fun getArtist(
        @Query(Constants.METHOD_PARAM) method: String,
        @Query(Constants.COUNTRY_PARAM) country: String,
        @Query(Constants.API_KEY_PARAM) api_key: String,
        @Query(Constants.FORMAT_PARAM) format: String
    ): ApiResponseArtist

}