package com.fr.iem.marvel.model.character

import com.fr.iem.marvel.model.*
import com.google.gson.annotations.SerializedName

data class MarvelCharactersResults(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("thumbnail") var thumbnail: MarvelImage? = MarvelImage(),
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("comics") var comics: MarvelComics? = MarvelComics(),
    @SerializedName("series") var series: MarvelSeries? = MarvelSeries(),
    @SerializedName("stories") var stories: MarvelStories? = MarvelStories(),
    @SerializedName("events") var events: MarvelEvents? = MarvelEvents(),
    @SerializedName("urls") var urls: ArrayList<MarvelUrls> = arrayListOf()
)
