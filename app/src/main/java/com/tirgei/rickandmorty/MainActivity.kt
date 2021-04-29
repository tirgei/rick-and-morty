/*
 * Copyright 2020 GradleBuildPlugins
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tirgei.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tirgei.data.remote.repositories.CharactersRepository
import com.tirgei.domain.onError
import com.tirgei.domain.onSuccess
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 *  Main Activity which is the Launcher Activity
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: CharactersRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            val result = repository.getCharacters()
            withContext(Dispatchers.Main) {
                result
                    .onSuccess {
                        Timber.i("Success -> $it")
                    }
                    .onError {
                        Timber.e("Error -> $it")
                    }
            }

            val characterResult = repository.getCharacter(16)
            withContext(Dispatchers.Main) {
                characterResult.onSuccess {
                    Timber.i("Character -> $it")
                }.onError {
                    Timber.e("Character error -> $it")
                }
            }

        }

    }
}