package com.tirgei.rickandmorty.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tirgei.data.remote.NetworkResponse
import com.tirgei.domain.models.Character
import com.tirgei.domain.onError
import com.tirgei.domain.onSuccess
import com.tirgei.domain.usecases.GetCharactersUseCase
import com.tirgei.rickandmorty.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): BaseViewModel() {

    private val _charactersLiveData = MutableLiveData<NetworkResponse<List<Character>>>()
    val charactersLiveData = _charactersLiveData

    fun fetchCharacters() {
        _charactersLiveData.postValue(NetworkResponse.Loading)

        launchCoroutine {
            val result = getCharactersUseCase.invoke()
            result.onSuccess { characters -> _charactersLiveData.postValue(NetworkResponse.Success(characters)) }
                .onError { error -> _charactersLiveData.postValue(NetworkResponse.Error(error)) }
        }
    }

}