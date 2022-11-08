package com.fr.iem.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelVariants(
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null
)
