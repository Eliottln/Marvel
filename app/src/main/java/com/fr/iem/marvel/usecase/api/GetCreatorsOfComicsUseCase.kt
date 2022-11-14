package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.models.creators.MarvelCreatorsResponse

class GetCreatorsOfComicsUseCase {

    suspend operator fun invoke(comicsId: Int): MarvelCreatorsResponse {
        return RetrofitServiceManagerImpl().getCreatorsOfComics(comicsId)
    }

}