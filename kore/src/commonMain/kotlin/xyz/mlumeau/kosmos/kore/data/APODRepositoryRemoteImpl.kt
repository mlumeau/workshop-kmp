package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

class APODRepositoryRemoteImpl : APODRepositoryRemote {
    private val nasaAPI: NasaApi = NasaAPIRemote()

    override suspend fun getAPOD() = nasaAPI.getAPOD()
}