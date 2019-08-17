package xyz.mlumeau.kosmos.usecases.implementations

import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi
import xyz.mlumeau.kosmos.usecases.GetAPOD

class GetAPODImpl(
    private val nasaAPI: NasaApi = NasaAPIRemote()
) : GetAPOD {
    override suspend fun invoke() = nasaAPI.getAPOD()
}