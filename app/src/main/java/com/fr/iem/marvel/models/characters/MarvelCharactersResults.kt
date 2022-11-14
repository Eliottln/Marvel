package com.fr.iem.marvel.models.characters

import com.fr.iem.marvel.models.MarvelImage
import com.fr.iem.marvel.models.MarvelInfos
import com.google.gson.annotations.SerializedName
import fr.iem.models.*

data class MarvelCharactersResults(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("thumbnail") var thumbnail: MarvelImage? = MarvelImage(),
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("comics") var comics: MarvelInfos? = MarvelInfos(),
    @SerializedName("series") var series: MarvelInfos? = MarvelInfos(),
    @SerializedName("stories") var stories: MarvelInfos? = MarvelInfos(),
    @SerializedName("events") var events: MarvelInfos? = MarvelInfos(),
    @SerializedName("urls") var urls: ArrayList<MarvelUrls> = arrayListOf()
)
