package com.fr.iem.marvel.models

import com.google.gson.annotations.SerializedName

data class MarvelImage(
    @SerializedName("path") var path: String? = null,
    @SerializedName("extension") var extension: String? = null
)