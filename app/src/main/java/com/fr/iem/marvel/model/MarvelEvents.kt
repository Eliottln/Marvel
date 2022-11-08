package com.fr.iem.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelEvents(

    @SerializedName("available") var available: Int? = null,
    @SerializedName("collectionURI") var collectionURI: String? = null,
    @SerializedName("items") var items: ArrayList<MarvelItems> = arrayListOf(),
    @SerializedName("returned") var returned: Int? = null

)