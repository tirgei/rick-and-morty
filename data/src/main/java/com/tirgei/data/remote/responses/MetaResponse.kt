package com.tirgei.data.remote.responses

import com.google.gson.annotations.SerializedName

/**
 * Data class for response metadata
 */
data class MetaResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("prev")
    var prev: String? = null
)
