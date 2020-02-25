package xyz.mlumeau.kosmos.kore.data

import kotlinx.coroutines.launch
import xyz.mlumeau.kosmos.kore.coroutineScope
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.service.nasa.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

class APODRepositoryRemoteImpl : APODRepositoryRemote {
    private val nasaAPI: NasaApi = NasaAPIRemote()

    private suspend fun getAPOD() = nasaAPI.getAPOD()

    override fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit) {
        coroutineScope.launch {
            var apod: APOD? = null
            try {
                apod = getAPOD()
            } catch (e: Exception) {
                println(e.message)
            }

            if (apod != null) {
                completion(apod)
            } else {
                failure()
            }
        }
    }
}