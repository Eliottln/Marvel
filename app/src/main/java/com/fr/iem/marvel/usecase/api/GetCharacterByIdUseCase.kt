package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.models.characters.MarvelCharactersResponse

class GetCharacterByIdUseCase {

    suspend operator fun invoke(characterId: Int): MarvelCharactersResponse {
        return RetrofitServiceManagerImpl().getCharacterById(characterId)
    }

}