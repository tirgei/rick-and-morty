package com.tirgei.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: LocationResponse,
    @SerializedName("location")
    val location: LocationResponse,
    @SerializedName("image")
    val image: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("error")
    var error: String? = null,
    @SerializedName("episode")
    var episodes: List<String> = emptyList()
)