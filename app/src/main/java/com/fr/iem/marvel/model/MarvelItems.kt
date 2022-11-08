package com.fr.iem.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelItems(
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("type") var type: String? = null
)
