package com.ivanbarbosa.toptunes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.entities.artists.ApiResponseArtist
import com.ivanbarbosa.toptunes.model.MainModel
import kotlinx.coroutines.launch

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes
* Create by Ivan Barbosa on 15/06/2023 at 4:27 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class MainViewModel: ViewModel() {
    private val mainModel = MainModel()
    private val result = MutableLiveData<ApiResponseArtist>()
    private val snackbarMsg = MutableLiveData<Int>()
    private val loaded = MutableLiveData<Boolean>()


    fun getResult(): LiveData<ApiResponseArtist> = result

    fun getSnackbarMsg() = snackbarMsg

    fun isLoaded() = loaded

    fun getArtist(method: String, country: String, apiKey: String, format: String){
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = mainModel.getTopArtist(method, country, apiKey, format)
                result.value = resultServer
                if (resultServer.topartists.artist.isEmpty()){
                    snackbarMsg.value = R.string.main_error_empty_artist
                }
            } catch (e: Exception) {
                snackbarMsg.value = R.string.error_server
            }finally {
                loaded.value = true
            }
        }
    }
}