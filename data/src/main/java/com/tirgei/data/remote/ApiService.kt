package com.tirgei.data.remote

import com.tirgei.data.remote.responses.CharacterResponse
import com.tirgei.data.remote.responses.ListItemsResponse
import com.tirgei.data.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.URL_CHARACTERS)
    suspend fun getCharacters(): ListItemsResponse<CharacterResponse>

    @GET(Constants.URL_SINGLE_CHARACTER)
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse
}