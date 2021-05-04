package com.tirgei.rickandmorty.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tirgei.data.remote.NetworkResponse
import com.tirgei.domain.models.Character
import com.tirgei.domain.onError
import com.tirgei.domain.onSuccess
import com.tirgei.domain.usecases.GetCharacterUseCase
import com.tirgei.domain.usecases.GetCharactersUseCase
import com.tirgei.rickandmorty.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharacterUseCase: GetCharacterUseCase
): BaseViewModel() {

    private val _charactersLiveData = MutableLiveData<NetworkResponse<List<Character>>>()
    val charactersLiveData = _charactersLiveData

    private val _characterLiveData = MutableLiveData<NetworkResponse<Character>>()
    val characterLiveData = _characterLiveData

    fun fetchCharacters() {
        _charactersLiveData.postValue(NetworkResponse.Loading)

        launchCoroutine {
            getCharactersUseCase.invoke().collectLatest { result ->
                result.onSuccess { characters -> _charactersLiveData.postValue(NetworkResponse.Success(characters)) }
                    .onError { error -> _charactersLiveData.postValue(NetworkResponse.Error(error)) }
            }
        }
    }

    fun fetchSpecificCharacter(id: Int) {
        _characterLiveData.postValue(NetworkResponse.Loading)

        launchCoroutine {
            getCharacterUseCase.invoke(id).collectLatest { result ->
                result.onSuccess { character -> _characterLiveData.postValue(NetworkResponse.Success(character)) }
                    .onError { error -> _characterLiveData.postValue(NetworkResponse.Error(error)) }
            }
        }
    }

}