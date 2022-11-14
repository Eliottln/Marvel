package com.fr.iem.marvel.usecase.api

import com.fr.iem.marvel.manager.service.RetrofitServiceManagerImpl
import com.fr.iem.marvel.models.comics.MarvelComicsResponse

class GetComicsUseCase {

    suspend operator fun invoke(): MarvelComicsResponse {
        return RetrofitServiceManagerImpl().getComics()
    }

}