package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.model.APOD

interface APODRepositoryCache {
    suspend fun getAPOD(): APOD
}