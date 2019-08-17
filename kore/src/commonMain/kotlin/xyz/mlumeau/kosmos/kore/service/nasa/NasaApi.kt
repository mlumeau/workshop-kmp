package xyz.mlumeau.kosmos.kore.service.nasa

import kotlinx.coroutines.Job
import xyz.mlumeau.kosmos.kore.APOD

interface NasaApi {
    fun getAPOD(completion: (APOD) -> Unit) : Job
    suspend fun getAPOD(): APOD
}