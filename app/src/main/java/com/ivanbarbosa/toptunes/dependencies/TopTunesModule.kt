package com.ivanbarbosa.toptunes.dependencies

import com.ivanbarbosa.toptunes.dataAccess.ApiService
import com.ivanbarbosa.toptunes.model.MainModel
import com.ivanbarbosa.toptunes.utils.Constants
import com.ivanbarbosa.toptunes.viewModel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.dependencies
* Create by Ivan Barbosa on 7/09/2023 at 5:15 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
@Module
@InstallIn(SingletonComponent::class)
object TopTunesModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}