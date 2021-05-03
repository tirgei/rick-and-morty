package com.tirgei.rickandmorty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tirgei.data.remote.onError
import com.tirgei.data.remote.onLoading
import com.tirgei.data.remote.onSuccess
import com.tirgei.rickandmorty.R
import com.tirgei.rickandmorty.databinding.FragmentCharactersBinding
import com.tirgei.rickandmorty.ui.base.BaseFragment
import com.tirgei.rickandmorty.ui.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    private val viewModel by viewModels<CharactersViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCharactersBinding
        get() = FragmentCharactersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCharactersObserver()
        viewModel.fetchCharacters()
    }

    private fun initCharactersObserver() {
        viewModel.charactersLiveData.observe(viewLifecycleOwner, { response ->
            response.onLoading { binding.loading = true }
                .onSuccess {
                    binding.loading = false
                    binding.emptyState = true
                }
                .onError {
                    binding.loading = false
                    binding.emptyState = true
                }
        })
    }

}