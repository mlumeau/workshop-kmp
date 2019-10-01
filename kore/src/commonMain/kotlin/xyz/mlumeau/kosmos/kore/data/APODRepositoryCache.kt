package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.APOD

interface APODRepositoryCache {
    suspend fun getAPOD(): APOD?
    fun setLastCacheTime(lastCache: Long)
    fun isProjectsCacheExpired(): Boolean
}