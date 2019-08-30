package xyz.mlumeau.kosmos.kore.usecases.implementations

import xyz.mlumeau.kosmos.kore.APOD
import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.requestAPOD
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi
import xyz.mlumeau.kosmos.usecases.GetAPOD

class GetAPODImpl : GetAPOD {
    private val nasaAPI: NasaApi = NasaAPIRemote()
    override suspend fun invoke() = nasaAPI.getAPOD()

    override fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit) {
        requestAPOD(this, completion, failure)
    }
}