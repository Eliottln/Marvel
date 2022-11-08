package com.fr.iem.marvel.manager.service

import com.fr.iem.marvel.model.character.MarvelCharactersResponse
import com.fr.iem.marvel.model.comics.MarvelComicsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceManager {

    companion object {
        private const val BASE_URL = "https://gateway.marvel.com:443"

        @Synchronized
        fun getInstance(): RetrofitServiceManager {
            val client = OkHttpClient.Builder()
                .addInterceptor(ApiInterceptor())
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(RetrofitServiceManager::class.java)
        }

    }

    @GET("/v1/public/characters")
    suspend fun getCharacters(): MarvelCharactersResponse

    @GET("/v1/public/characters/{character_id}")
    suspend fun getCharacterById(@Path("character_id") characterId: Int): MarvelCharactersResponse

    @GET("/v1/public/comics")
    suspend fun getComics(): MarvelComicsResponse

    @GET("/v1/public/comics/{comics_id}")
    suspend fun getComicsById(@Path("comics_id") comicsId: Int): MarvelComicsResponse

    @GET("/v1/public/comics/{comics_id}/characters")
    suspend fun getCharactersInComics(@Path("comics_id") comicsId: Int): MarvelCharactersResponse

    @GET("/v1/public/comics/{comics_id}/creators")
    suspend fun getCreatorsOfComics(@Path("comics_id") comicsId: Int): MarvelCharactersResponse

}