package com.fr.iem.marvel.model.comics

import com.google.gson.annotations.SerializedName

data class MarvelComicsData(
    @SerializedName("offset") var offset: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("results") var results: ArrayList<MarvelComicsResults> = arrayListOf()
)
