package com.fr.iem.marvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fr.iem.marvel.models.characters.MarvelCharactersResults
import com.fr.iem.marvel.models.comics.MarvelComicsResults
import com.fr.iem.marvel.models.creators.MarvelCreatorsResults
import com.fr.iem.marvel.usecase.api.*
import kotlinx.coroutines.launch

abstract class DetailsViewModel: ViewModel() {
    abstract fun getComicsById(id: Int)
    abstract fun getCharacterById(id: Int)
    abstract fun getCharactersInComics(id: Int)
    abstract fun getComicsWithCharacter(id: Int)
    abstract fun getCreatorsOfComics(id: Int)
    abstract val comics: LiveData<MarvelComicsResults>
    abstract val character: LiveData<MarvelCharactersResults>
    abstract val charactersList: LiveData<List<MarvelCharactersResults>>
    abstract val comicsList: LiveData<List<MarvelComicsResults>>
    abstract val creatorsList: LiveData<List<MarvelCreatorsResults>>
}


class DetailsViewModelImpl: DetailsViewModel() {
    private val _comics = MutableLiveData<MarvelComicsResults>()
    override val comics: LiveData<MarvelComicsResults> = _comics
    private val _character = MutableLiveData<MarvelCharactersResults>()
    override val character: LiveData<MarvelCharactersResults> = _character
    private val _charactersList = MutableLiveData<List<MarvelCharactersResults>>()
    override val charactersList: LiveData<List<MarvelCharactersResults>> = _charactersList
    private val _comicsList = MutableLiveData<List<MarvelComicsResults>>()
    override val comicsList: LiveData<List<MarvelComicsResults>> = _comicsList
    private val _creatorsList = MutableLiveData<List<MarvelCreatorsResults>>()
    override val creatorsList: LiveData<List<MarvelCreatorsResults>> = _creatorsList

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
                    _charactersList.postValue(it)
                }
            }
        }
    }

    override fun getComicsWithCharacter(id: Int) {
        viewModelScope.launch {
            GetComicsWithCharacterUseCase().invoke(id).let { response ->
                response.data.results.let {
                    _comicsList.postValue(it)
                }
            }
        }
    }

    override fun getCreatorsOfComics(id: Int) {
        viewModelScope.launch {
            GetCreatorsOfComicsUseCase().invoke(id).let { response ->
                response.data.results.let {
                    _creatorsList.postValue(it)
                }
            }
        }
    }

}