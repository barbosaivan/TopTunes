package com.ivanbarbosa.toptunes.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.entities.artists.ApiResponseArtist
import com.ivanbarbosa.toptunes.fakeTopArtist
import com.ivanbarbosa.toptunes.fakeTopArtistEmpty
import com.ivanbarbosa.toptunes.model.MainModel
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

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.viewModel
* Create by Ivan Barbosa on 11/09/2023 at 11:30 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@ExperimentalCoroutinesApi
class MainViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    private lateinit var mainModel: MainModel

    @Mock
    private lateinit var observerResult: Observer<ApiResponseArtist>

    @Mock
    private lateinit var observerSnackbarMsg: Observer<Int>

    @Mock
    private lateinit var observerLoad: Observer<Boolean>

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        mainViewModel = MainViewModel(mainModel)
        mainViewModel.getResult().observeForever(observerResult)
        mainViewModel.getSnackbarMsg().observeForever(observerSnackbarMsg)
        mainViewModel.isLoaded().observeForever(observerLoad)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetArtistSuccess() = testScope.runTest {
        val mockResponse = ApiResponseArtist(fakeTopArtist())
        Mockito.`when`(
            mainModel.getTopArtist(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        ).thenReturn(mockResponse)

        mainViewModel.getArtist("method", "country", "apiKey", "format")

        Mockito.verify(observerResult).onChanged(mockResponse)
        Mockito.verify(observerSnackbarMsg, Mockito.never()).onChanged(Mockito.anyInt())
        Mockito.verify(observerLoad, Mockito.times(1)).onChanged(false)
    }

    @Test
    fun testGetArtistEmptyResult() = testScope.runTest {
        val mockResponseArtist = ApiResponseArtist(fakeTopArtistEmpty())
        Mockito.`when`(
            mainModel.getTopArtist(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        ).thenReturn(mockResponseArtist)

        mainViewModel.getArtist("method", "country", "apiKey", "format")

        Mockito.verify(observerResult).onChanged(mockResponseArtist)
        Mockito.verify(observerSnackbarMsg).onChanged(R.string.main_error_empty_artist)
        Mockito.verify(observerLoad, Mockito.times(1)).onChanged(false)
    }

    @Test
    fun testGetArtistException() = testScope.runTest {
        Mockito.`when`(
            mainModel.getTopArtist(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
            )
        ).thenThrow(RuntimeException("Test Exception"))

        mainViewModel.getArtist("method", "country", "apiKey", "format")

        Mockito.verify(observerSnackbarMsg).onChanged(R.string.error_server)
    }
}