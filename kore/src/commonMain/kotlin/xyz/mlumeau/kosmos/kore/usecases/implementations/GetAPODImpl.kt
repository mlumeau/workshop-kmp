package xyz.mlumeau.kosmos.kore.usecases.implementations

import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCache
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemote
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl
import xyz.mlumeau.kosmos.kore.requestAPOD
import xyz.mlumeau.kosmos.kore.usecases.GetConnectionState
import xyz.mlumeau.kosmos.usecases.GetAPOD

class GetAPODImpl(private val getConnectionState: GetConnectionState) : GetAPOD {

    private val apodRepositoryCache: APODRepositoryCache = APODRepositoryCacheImpl()
    private val apodRepositoryRemote: APODRepositoryRemote = APODRepositoryRemoteImpl()

    override suspend fun invoke() = if (getConnectionState.isConnectedToNetwork()) {
        apodRepositoryRemote.getAPOD()
    } else {
        apodRepositoryCache.getAPOD()
    }

    override fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit) {
        requestAPOD(this, completion, failure)
    }
}