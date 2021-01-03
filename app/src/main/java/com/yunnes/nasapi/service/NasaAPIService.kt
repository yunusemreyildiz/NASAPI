package com.yunnes.nasapi.service

import com.yunnes.nasapi.models.Rover
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor



class NasaAPIService {

    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                // level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    private val api = Retrofit.Builder()
            .baseUrl(BaseURL.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun getNasa(): NasaAPI {
        return api.create(NasaAPI::class.java)
    }


}