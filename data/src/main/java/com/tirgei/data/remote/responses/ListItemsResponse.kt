package com.tirgei.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ListItemsResponse<out T> (
    @SerializedName("info")
    val info: MetaResponse,
    @SerializedName("results")
    val results: List<T>
)