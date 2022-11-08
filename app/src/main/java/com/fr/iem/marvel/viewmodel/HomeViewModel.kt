package com.fr.iem.marvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fr.iem.marvel.model.character.MarvelCharactersResults
import com.fr.iem.marvel.model.comics.MarvelComicsResults
import com.fr.iem.marvel.usecase.api.GetCharacterByIdUseCase
import com.fr.iem.marvel.usecase.api.GetCharactersUseCase
import com.fr.iem.marvel.usecase.api.GetComicsUseCase
import kotlinx.coroutines.launch

abstract class HomeViewModel : ViewModel() {
    abstract fun getComics()
    abstract fun getCharacters()
    abstract val comicsList: LiveData<List<MarvelComicsResults>>
    abstract val charactersList: LiveData<List<MarvelCharactersResults>>
}

class HomeViewModelImpl : HomeViewModel() {

    private val _comicsList = MutableLiveData<List<MarvelComicsResults>>()
    override val comicsList: LiveData<List<MarvelComicsResults>> = _comicsList
    private val _charactersList = MutableLiveData<List<MarvelCharactersResults>>()
    override val charactersList: LiveData<List<MarvelCharactersResults>> = _charactersList

    override fun getComics() {
        viewModelScope.launch {
            GetComicsUseCase().invoke().let { response ->
                response.data?.results?.let {
                    _comicsList.postValue(it)
                }
            }
        }
    }

    override fun getCharacters() {
        viewModelScope.launch {
            GetCharactersUseCase().invoke().let { response ->
                response.data.results.let {
                    _charactersList.postValue(it)
                }
            }
        }
    }

}