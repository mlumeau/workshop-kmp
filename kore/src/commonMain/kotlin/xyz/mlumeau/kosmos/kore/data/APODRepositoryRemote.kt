package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.APOD

interface APODRepositoryRemote {
    suspend fun getAPOD(): APOD?
    fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit)
}