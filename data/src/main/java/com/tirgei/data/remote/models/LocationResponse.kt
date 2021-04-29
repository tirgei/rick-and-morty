package com.tirgei.data.remote.models

import com.google.gson.annotations.SerializedName

data class LocationResponse(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("dimension")
        val dimension: String,
        @SerializedName("url")
        val url: String
)
