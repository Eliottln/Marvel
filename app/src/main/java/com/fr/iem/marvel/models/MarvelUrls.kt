package fr.iem.models

import com.google.gson.annotations.SerializedName

data class MarvelUrls(
    @SerializedName("type") var type: String? = null,
    @SerializedName("url") var url: String? = null
)
