package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.dataAccess.ApiService
import com.ivanbarbosa.toptunes.entities.tracks.ApiResponseTrack
import com.ivanbarbosa.toptunes.fakeTopTracksArtist
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.model
* Create by Ivan Barbosa on 8/09/2023 at 12:41 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@ExperimentalCoroutinesApi
class RequestApiTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    private lateinit var apiService: ApiService

    private lateinit var requestApi: RequestApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        requestApi = RequestApi(apiService)
    }

    @Test
    fun testGetTopTracksSuccess() = testScope.runTest {
        val mockResponse = ApiResponseTrack(fakeTopTracksArtist())

        Mockito.`when`(
            apiService.getTrack(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        )
            .thenReturn(mockResponse)

        val result = requestApi.getTopTracks("method", "artist", "apiKey", "format")

        Assert.assertEquals(mockResponse, result)
    }
}