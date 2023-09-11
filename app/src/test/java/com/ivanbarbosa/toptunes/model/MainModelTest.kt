package com.ivanbarbosa.toptunes.model

import com.ivanbarbosa.toptunes.entities.artists.ApiResponseArtist
import com.ivanbarbosa.toptunes.fakeTopArtist
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
* Create by Ivan Barbosa on 11/09/2023 at 12:54 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@ExperimentalCoroutinesApi
class MainModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    private lateinit var requestApi: RequestApi

    private lateinit var mainModel: MainModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mainModel = MainModel(requestApi)
    }

    @Test
    fun testGetTopArtistSuccess() = testScope.runTest {
        val mockResponse = ApiResponseArtist(fakeTopArtist())
        Mockito.`when`(
            requestApi.getTopArtist(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        ).thenReturn(mockResponse)

        val result = mainModel.getTopArtist("method", "country", "apiKey", "format")

        Assert.assertEquals(result, mockResponse)
    }

}