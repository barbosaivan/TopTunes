package com.ivanbarbosa.toptunes.model

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
* Create by Ivan Barbosa on 8/09/2023 at 12:08 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@ExperimentalCoroutinesApi
class ArtistModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    private lateinit var requestApi: RequestApi

    private lateinit var artistModel: ArtistModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        artistModel = ArtistModel(requestApi)
    }

    @Test
    fun testGetTopTrackSuccess() = testScope.runTest {
        val mockResponse = ApiResponseTrack(fakeTopTracksArtist())

        Mockito.`when`(
            requestApi.getTopTracks(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        )
            .thenReturn(mockResponse)

        val result = artistModel.getTopTrack("method", "artist", "apiKey", "format")

        Assert.assertEquals(mockResponse, result)
    }
}