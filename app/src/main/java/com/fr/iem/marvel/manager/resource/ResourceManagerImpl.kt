package com.fr.iem.marvel.manager.resource

import java.io.File
import java.util.*

/**
 * Use like this
 *
 * val resourceManager: ResourceManager = ResourceManagerImpl()
 *
 */
class ResourceManagerImpl(
    private val directoryPath: String = ResourceManager.DEFAULT_RESOURCES_DIRECTORY
) : ResourceManager {

    override fun readFile(path: String): String? {
        return try {
            File(directoryPath, path).readText()
        } catch (e: Exception) {
            println(e)
            null
        }
    }

    override fun readProperties(key: String): String {
        var propertiesValue = ""
        try {
            val properties = Properties()
            val file = File(directoryPath, ResourceManager.PROPERTIES_PATH).inputStream()
            properties.load(file)
            propertiesValue = properties.getProperty(key)
        } catch (e: Exception) {
            println(e)
        }

        return propertiesValue
    }
}