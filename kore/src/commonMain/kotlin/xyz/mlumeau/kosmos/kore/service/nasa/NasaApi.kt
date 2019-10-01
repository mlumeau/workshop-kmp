package xyz.mlumeau.kosmos.kore.service.nasa

import xyz.mlumeau.kosmos.kore.APOD

internal interface NasaApi {
    suspend fun getAPOD(): APOD?
}