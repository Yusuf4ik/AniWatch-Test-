package com.example.aniwatch.data

import retrofit2.Response

class Repository(private val networkUtils: NetworkUtils) : RepoImp {
    override suspend fun getAnime(code: String): Response<Anime> {
        return networkUtils.getAnimes(code)
    }
}