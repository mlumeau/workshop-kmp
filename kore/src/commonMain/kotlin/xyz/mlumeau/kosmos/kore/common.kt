package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl
import xyz.mlumeau.kosmos.kore.model.APOD

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

expect fun requestAPOD(
    apodRepositoryRemote: APODRepositoryRemoteImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
)

expect fun requestAPOD(
    apodRepositoryCache: APODRepositoryCacheImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
)