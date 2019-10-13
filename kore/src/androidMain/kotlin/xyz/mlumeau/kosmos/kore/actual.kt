package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl
import xyz.mlumeau.kosmos.kore.model.APOD

actual fun platformName(): String {
    return "Android"
}

actual fun requestAPOD(
    apodRepositoryRemote: APODRepositoryRemoteImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
) {
    TODO("The Android app must use the suspend function instead.")
}

actual fun requestAPOD(
    apodRepositoryCache: APODRepositoryCacheImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
) {
    TODO("The Android app must use the suspend function instead.")
}