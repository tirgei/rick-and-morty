package com.tirgei.rickandmorty.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.tirgei.data.remote.NetworkResponse
import com.tirgei.domain.usecases.GetCharacterUseCase
import com.tirgei.domain.usecases.GetCharactersUseCase
import com.tirgei.rickandmorty.fakes.FakeCharactersRepository
import com.tirgei.rickandmorty.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharactersViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CharactersViewModel

    @Before
    fun setup() {
        val repo = FakeCharactersRepository()
        viewModel = CharactersViewModel(
            GetCharactersUseCase(repo),
            GetCharacterUseCase(repo)
        )
    }

    @Test
    fun `fetch characters returns list of 1 character`() {
        viewModel.fetchCharacters()

        val value = viewModel.charactersLiveData.getOrAwaitValue()
        val result = value as NetworkResponse.Success

        assertThat(value).isInstanceOf(NetworkResponse.Success::class.java)
        assertThat(result.data).isNotEmpty()
        assertThat(result.data.size).isEqualTo(1)
    }

    @Test
    fun `fetch character that doesn't exist returns error message`() {
        viewModel.fetchCharacter(2)

        val value = viewModel.characterLiveData.getOrAwaitValue()
        val result = value as NetworkResponse.Error

        assertThat(value).isInstanceOf(NetworkResponse.Error::class.java)
        assertThat(result.message).isEqualTo("Unable to fetch character")
    }

    @Test
    fun `fetch character with id 1 returns character`() {
        viewModel.fetchCharacter(1)

        val value = viewModel.characterLiveData.getOrAwaitValue()
        val result = value as NetworkResponse.Success

        assertThat(value).isInstanceOf(NetworkResponse.Success::class.java)
        assertThat(result.data.name).isEqualTo("Rick Mortez")
    }

}