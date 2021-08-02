package com.example.aniwatch.data

import retrofit2.Response

interface RepoImp {
    suspend fun getAnime(code: String): Response<Anime>
}