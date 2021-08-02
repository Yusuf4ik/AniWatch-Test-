package com.example.aniwatch.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {

    @GET("getTitle")
    suspend fun getAnimes(
        @Query("code") code: String
    ): Response<Anime>
    companion object {
        private var retrofitService: NetworkUtils? = null
        fun getInstance(): NetworkUtils {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(NetworkUtils::class.java)
            }
            return retrofitService!!
        }
    }
}