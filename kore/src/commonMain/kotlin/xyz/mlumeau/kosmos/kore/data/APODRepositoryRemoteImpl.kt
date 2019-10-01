package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.APOD
import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.requestAPOD
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

class APODRepositoryRemoteImpl : APODRepositoryRemote {
    private val nasaAPI: NasaApi = NasaAPIRemote()

    override suspend fun getAPOD() = nasaAPI.getAPOD()

    override fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit) {
        requestAPOD(this, completion, failure)
    }
}