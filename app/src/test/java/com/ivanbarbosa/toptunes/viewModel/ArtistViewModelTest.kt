package com.ivanbarbosa.toptunes.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.entities.tracks.*
import com.ivanbarbosa.toptunes.model.ArtistModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.RuntimeException

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.viewModel
* Create by Ivan Barbosa on 31/08/2023 at 11:03 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

@ExperimentalCoroutinesApi
class ArtistViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    private lateinit var artistModel: ArtistModel

    @Mock
    private lateinit var observer: Observer<ApiResponseTrack>

    @Mock
    private lateinit var snackbarObserver: Observer<Int>

    private lateinit var artistViewModel: ArtistViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        artistViewModel = ArtistViewModel()
        artistViewModel.setArtistModel(artistModel)
        artistViewModel.getResult().observeForever(observer)
        artistViewModel.getSnackbarMsg().observeForever(snackbarObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetTrack_Success() = testScope.runTest {
        val mockApiResponse = ApiResponseTrack(fakeTopTracksArtist())

        Mockito.`when`(
            artistModel.getTopTrack(
                Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString()
            )
        ).thenReturn(mockApiResponse)

        artistViewModel.getTrack(
            "method",
            "artist",
            "apiKey",
            "format"
        )

        Mockito.verify(observer).onChanged(mockApiResponse)
        Mockito.verify(snackbarObserver, Mockito.never()).onChanged(Mockito.anyInt())
    }

    @Test
    fun testGetTrackEmptyResult() = testScope.runTest {
        val mockApiResponse = ApiResponseTrack(fakeTopTracksArtistEmpty())
        Mockito.`when`(
            artistModel.getTopTrack(
                Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyString()
            )
        ).thenReturn(mockApiResponse)

        artistViewModel.getTrack("method", "artist", "apiKey", "format")

        Mockito.verify(observer).onChanged(mockApiResponse)
        Mockito.verify(snackbarObserver).onChanged(R.string.main_error_empty_artist)
    }

    @Test
    fun testGetTrackException() = testScope.runTest {
        Mockito.`when`(
            artistModel.getTopTrack(
                Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyString()
            )
        ).thenThrow(RuntimeException("Test exception"))

        artistViewModel.getTrack("method", "artist", "apiKey", "format")

        Mockito.verify(snackbarObserver).onChanged(R.string.error_server)
    }
}