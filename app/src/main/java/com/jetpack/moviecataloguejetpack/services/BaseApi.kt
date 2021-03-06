package com.jetpack.moviecataloguejetpack.services

import com.jetpack.moviecataloguejetpack.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseApi {

    private val interceptor = HttpLoggingInterceptor()
    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>) : S {
        return createService(serviceClass, null)
    }

    private fun <S> createService(serviceClass: Class<S>, authToken: String?) : S {
        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }
}