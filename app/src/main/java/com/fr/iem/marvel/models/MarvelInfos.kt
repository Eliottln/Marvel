package com.fr.iem.marvel.models

import com.google.gson.annotations.SerializedName

data class MarvelInfos(
    @SerializedName("available") var available: Int? = null,
    @SerializedName("collectionURI") var collectionURI: String? = null,
    @SerializedName("items") var items: ArrayList<MarvelItems> = arrayListOf(),
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null
)
