package com.fr.iem.marvel.manager.service

import com.fr.iem.marvel.model.character.MarvelCharactersResponse
import com.fr.iem.marvel.model.comics.MarvelComicsResponse

class RetrofitServiceManagerImpl : RetrofitServiceManager {

    private val service: RetrofitServiceManager = RetrofitServiceManager.getInstance()

    override suspend fun getCharacters(): MarvelCharactersResponse {
        return service.getCharacters()
    }

    override suspend fun getCharacterById(characterId: Int): MarvelCharactersResponse {
        return service.getCharacterById(characterId)
    }

    override suspend fun getComics(): MarvelComicsResponse {
        return service.getComics()
    }

    override suspend fun getComicsById(comicsId: Int): MarvelComicsResponse {
        return service.getComicsById(comicsId)
    }

    override suspend fun getCharactersInComics(comicsId: Int): MarvelCharactersResponse {
        return service.getCharactersInComics(comicsId)
    }

    override suspend fun getCreatorsOfComics(comicsId: Int): MarvelCharactersResponse {
        return service.getCreatorsOfComics(comicsId)
    }

}