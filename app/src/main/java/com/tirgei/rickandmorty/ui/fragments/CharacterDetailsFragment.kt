package com.tirgei.rickandmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tirgei.data.remote.onError
import com.tirgei.data.remote.onLoading
import com.tirgei.data.remote.onSuccess
import com.tirgei.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.tirgei.rickandmorty.ui.base.BaseFragment
import com.tirgei.rickandmorty.ui.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    private val viewModel by viewModels<CharactersViewModel>()
    private val args by navArgs<CharacterDetailsFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCharacterDetailsBinding
        get() = FragmentCharacterDetailsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBackPress()

        initCharacterObserver()
        viewModel.fetchCharacter(args.characterId)
    }

    private fun initCharacterObserver() {
        viewModel.characterLiveData.observe(viewLifecycleOwner, { response ->
            response.onLoading { binding.loading = true }
                .onSuccess { character ->
                    binding.loading = false
                    binding.character = character
                }
                .onError {
                    Timber.e("Error fetching character ${args.characterId}: $it")
                    findNavController().navigateUp()
                }
        })
    }

    private fun initBackPress() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
}