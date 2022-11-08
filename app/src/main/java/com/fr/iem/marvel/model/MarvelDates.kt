package com.fr.iem.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelDates(
    @SerializedName("type") var type: String? = null,
    @SerializedName("date") var date: String? = null
)
