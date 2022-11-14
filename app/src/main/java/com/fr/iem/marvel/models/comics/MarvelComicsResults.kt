package com.fr.iem.marvel.models.comics

import com.fr.iem.marvel.models.MarvelDates
import com.fr.iem.marvel.models.MarvelImage
import com.fr.iem.marvel.models.MarvelInfos
import com.fr.iem.marvel.models.MarvelItems
import com.google.gson.annotations.SerializedName
import fr.iem.models.*

data class MarvelComicsResults(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("digitalId") var digitalId: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("issueNumber") var issueNumber: Int? = null,
    @SerializedName("variantDescription") var variantDescription: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("isbn") var isbn: String? = null,
    @SerializedName("upc") var upc: String? = null,
    @SerializedName("diamondCode") var diamondCode: String? = null,
    @SerializedName("ean") var ean: String? = null,
    @SerializedName("issn") var issn: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("pageCount") var pageCount: Int? = null,
    @SerializedName("textObjects") var textObjects: ArrayList<MarvelTextObject> = arrayListOf(),
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("urls") var urls: ArrayList<MarvelUrls> = arrayListOf(),
    @SerializedName("series") var series: MarvelInfos? = MarvelInfos(),
    @SerializedName("variants") var variants: ArrayList<MarvelItems> = arrayListOf(),
    @SerializedName("collectedIssues") var collectedIssues: ArrayList<MarvelItems> = arrayListOf(),
    @SerializedName("dates") var dates: ArrayList<MarvelDates> = arrayListOf(),
    @SerializedName("prices") var prices: ArrayList<MarvelPrices> = arrayListOf(),
    @SerializedName("thumbnail") var thumbnail: MarvelImage? = MarvelImage(),
    @SerializedName("images") var images: ArrayList<MarvelImage> = arrayListOf(),
    @SerializedName("creators") var creators: MarvelInfos? = MarvelInfos(),
    @SerializedName("characters") var characters: MarvelInfos? = MarvelInfos(),
    @SerializedName("stories") var stories: MarvelInfos? = MarvelInfos(),
    @SerializedName("events") var events: MarvelInfos? = MarvelInfos()
)
