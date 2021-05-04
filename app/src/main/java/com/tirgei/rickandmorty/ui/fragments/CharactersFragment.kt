package com.tirgei.rickandmorty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tirgei.data.remote.onError
import com.tirgei.data.remote.onLoading
import com.tirgei.data.remote.onSuccess
import com.tirgei.domain.models.Character
import com.tirgei.rickandmorty.R
import com.tirgei.rickandmorty.databinding.FragmentCharactersBinding
import com.tirgei.rickandmorty.ui.adapters.CharactersAdapter
import com.tirgei.rickandmorty.ui.base.BaseFragment
import com.tirgei.rickandmorty.ui.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    private val viewModel by viewModels<CharactersViewModel>()
    private lateinit var charactersAdapter: CharactersAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCharactersBinding
        get() = FragmentCharactersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initCharactersObserver()
        viewModel.fetchCharacters()
    }

    private fun initViews() {
        charactersAdapter = CharactersAdapter(this::onCharacterClicked)
        binding.charactersRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = charactersAdapter
        }
    }

    private fun onCharacterClicked(character: Character) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(character.id)
        findNavController().navigate(action)

    }

    private fun initCharactersObserver() {
        viewModel.charactersLiveData.observe(viewLifecycleOwner, { response ->
            response.onLoading { binding.loading = true }
                .onSuccess { characters ->
                    binding.loading = false

                    if (characters.isEmpty()) {
                        binding.emptyState = true
                    } else {
                        binding.emptyState = false
                        charactersAdapter.addCharacters(characters)
                    }
                }
                .onError {
                    binding.loading = false
                    binding.emptyState = true
                    Timber.e("Error fetching characters: $it")
                }
        })
    }

}