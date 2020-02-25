package xyz.mlumeau.kosmos.kore.usecases.implementations

import kotlinx.coroutines.launch
import xyz.mlumeau.kosmos.kore.coroutineScope
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCache
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemote
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.GetAPOD
import xyz.mlumeau.kosmos.kore.usecases.GetConnectionState

class GetAPODImpl(private val getConnectionState: GetConnectionState) : GetAPOD {

    private val apodRepositoryCache: APODRepositoryCache = APODRepositoryCacheImpl()
    private val apodRepositoryRemote: APODRepositoryRemote = APODRepositoryRemoteImpl()

    private suspend fun getAPOD() = if (getConnectionState.isConnectedToNetwork()) {
        apodRepositoryRemote.getAPOD()
    } else {
        apodRepositoryCache.getAPOD()
    }

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