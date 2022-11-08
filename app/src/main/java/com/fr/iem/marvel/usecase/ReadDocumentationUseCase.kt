package com.fr.iem.marvel.usecase

import com.fr.iem.marvel.manager.resource.ResourceManager
import com.fr.iem.marvel.manager.resource.ResourceManagerImpl

class ReadDocumentationUseCase {
    private val resourceManager: ResourceManager = ResourceManagerImpl()

    operator fun invoke(): String? {
        return resourceManager.readFile(ResourceManager.DOCUMENTATION_PATH)
    }

}