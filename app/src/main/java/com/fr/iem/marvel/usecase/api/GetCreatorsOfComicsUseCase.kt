package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.model.character.MarvelCharactersResponse

class GetCreatorsOfComicsUseCase {

    suspend operator fun invoke(comicsId: Int): MarvelCharactersResponse {
        return RetrofitServiceManagerImpl().getCreatorsOfComics(comicsId)
    }

}