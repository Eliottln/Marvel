package com.fr.iem.marvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fr.iem.marvel.models.characters.MarvelCharactersResults
import com.fr.iem.marvel.models.comics.MarvelComicsResults
import com.fr.iem.marvel.usecase.api.GetCharacterByIdUseCase
import com.fr.iem.marvel.usecase.api.GetCharactersInComicsUseCase
import com.fr.iem.marvel.usecase.api.GetComicsByIdUseCase
import kotlinx.coroutines.launch

abstract class DetailsViewModel: ViewModel() {
    abstract fun getComicsById(id: Int)
    abstract fun getCharacterById(id: Int)
    abstract fun getCharactersInComics(id: Int)
    abstract val comics: LiveData<MarvelComicsResults>
    abstract val character: LiveData<MarvelCharactersResults>
    abstract val characters: LiveData<List<MarvelCharactersResults>>
}


class DetailsViewModelImpl: DetailsViewModel() {
    private val _comics = MutableLiveData<MarvelComicsResults>()
    override val comics: LiveData<MarvelComicsResults> = _comics
    private val _character = MutableLiveData<MarvelCharactersResults>()
    override val character: LiveData<MarvelCharactersResults> = _character
    private val _characters = MutableLiveData<List<MarvelCharactersResults>>()
    override val characters: LiveData<List<MarvelCharactersResults>> = _characters

    override fun getComicsById(id: Int) {
        viewModelScope.launch {
            GetComicsByIdUseCase().invoke(id).let { response ->
                response.data.results.let {
                    _comics.postValue(it[0])
                }
            }
        }
    }

    override fun getCharacterById(id: Int) {
        viewModelScope.launch {
            GetCharacterByIdUseCase().invoke(id).let { response ->
                response.data.results.let {
                    _character.postValue(it[0])
                }
            }
        }
    }

    override fun getCharactersInComics(id: Int) {
        viewModelScope.launch {
            GetCharactersInComicsUseCase().invoke(id).let { response ->
                response.data.results.let {
                    _characters.postValue(it)
                }
            }
        }
    }

}