package com.ivanbarbosa.toptunes.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.enities.tracks.ApiResponseTrack
import com.ivanbarbosa.toptunes.model.ArtistModel
import kotlinx.coroutines.launch

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.viewModel
* Create by Ivan Barbosa on 16/06/2023 at 1:50 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/class ArtistViewModel : ViewModel() {
    private val artistModel = ArtistModel()
    private val result = MutableLiveData<ApiResponseTrack>()
    private val snackbarMsg = MutableLiveData<Int>()

    fun getResult(): LiveData<ApiResponseTrack> = result

    fun getSnackbarMsg() = snackbarMsg

    fun getTrack(method: String, artist: String, apiKey: String, format: String) {
        viewModelScope.launch {
            try {
                val resultServer = artistModel.getTopTrack(method, artist, apiKey, format)
                result.value = resultServer
                if (resultServer.toptracks.track.isEmpty()) {
                    snackbarMsg.value = R.string.main_error_empty_artist
                }
            } catch (e: Exception) {
                snackbarMsg.value = R.string.error_server
                Log.e("Error", e.message.toString())
            }
        }
    }
}