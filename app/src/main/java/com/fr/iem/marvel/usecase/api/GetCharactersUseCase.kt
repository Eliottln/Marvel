package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.models.characters.MarvelCharactersResponse

class GetCharactersUseCase {

    suspend operator fun invoke(): MarvelCharactersResponse {
        return RetrofitServiceManagerImpl().getCharacters()
    }

}