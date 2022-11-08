package com.fr.iem.marvel.model.character

import com.google.gson.annotations.SerializedName

data class MarvelCharactersData(

    @SerializedName("offset") var offset: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("results") var results: ArrayList<MarvelCharactersResults> = arrayListOf()

)