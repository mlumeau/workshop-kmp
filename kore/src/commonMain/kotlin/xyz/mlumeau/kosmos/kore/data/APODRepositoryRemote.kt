package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.model.APOD

interface APODRepositoryRemote {
    suspend fun getAPOD(): APOD
}