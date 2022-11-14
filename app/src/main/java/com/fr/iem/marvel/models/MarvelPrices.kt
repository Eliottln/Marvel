package fr.iem.models

import com.google.gson.annotations.SerializedName

data class MarvelPrices(
    @SerializedName("type") var type: String? = null,
    @SerializedName("price") var price: Float? = null
)
