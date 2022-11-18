package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.models.comics.MarvelComicsResponse

class GetComicsWithCharacterUseCase {

    suspend operator fun invoke(characterId: Int): MarvelComicsResponse {
        return RetrofitServiceManagerImpl().getComicsWithCharacter(characterId)
    }

}