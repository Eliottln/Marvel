package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.model.character.MarvelCharactersResponse
import com.fr.iem.marvel.model.comics.MarvelComicsResponse

class GetComicsByIdUseCase {

    suspend operator fun invoke(comicsId: Int): MarvelComicsResponse {
        return RetrofitServiceManagerImpl().getComicsById(comicsId)
    }

}