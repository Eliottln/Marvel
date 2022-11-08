package com.fr.iem.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelTextObject(
    @SerializedName("type") var type: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("text") var text: String? = null,
)
