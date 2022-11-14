package com.fr.iem.marvel.models.creators

import com.fr.iem.marvel.models.MarvelImage
import com.fr.iem.marvel.models.MarvelInfos
import com.google.gson.annotations.SerializedName
import fr.iem.models.*

data class MarvelCreatorsResults(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("middleName") var middleName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("suffix") var suffix: String? = null,
    @SerializedName("fullName") var fullName: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("thumbnail") var thumbnail: MarvelImage? = MarvelImage(),
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("comics") var comics: MarvelInfos? = MarvelInfos(),
    @SerializedName("series") var series: MarvelInfos? = MarvelInfos(),
    @SerializedName("stories") var stories: MarvelInfos? = MarvelInfos(),
    @SerializedName("events") var events: MarvelInfos? = MarvelInfos(),
    @SerializedName("urls") var urls: ArrayList<MarvelUrls> = arrayListOf()
)
