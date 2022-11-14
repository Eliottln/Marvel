package com.fr.iem.marvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fr.iem.marvel.models.comics.MarvelComicsResults
import com.fr.iem.marvel.usecase.api.GetComicsByIdUseCase
import kotlinx.coroutines.launch

abstract class DetailsViewModel: ViewModel() {
    abstract fun getComicsById(id: Int)
    abstract val comics: LiveData<MarvelComicsResults>
}


class DetailsViewModelImpl: DetailsViewModel() {
    private val _comics = MutableLiveData<MarvelComicsResults>()
    override val comics: LiveData<MarvelComicsResults> = _comics

    override fun getComicsById(id: Int) {
        viewModelScope.launch {
            GetComicsByIdUseCase().invoke(id).let { response ->
                response.data?.results?.let {
                    _comics.postValue(it[0])
                }
            }
        }
    }

}