package com.fr.iem.marvel.manager.resource

interface ResourceManager {

    companion object {

        const val DEFAULT_RESOURCES_DIRECTORY = "src/main/resources/"

        const val DOCUMENTATION_PATH = "txt/documentation.txt"
        const val IRONMAN_PATH: String = "json/iron_man.json"
        const val RESPONSE_PATH: String = "json/response.json"
        const val PROPERTIES_PATH: String = "properties/marvel_api_key.properties"

    }

    fun readFile(path: String): String?

    fun readProperties(key: String): String?

}