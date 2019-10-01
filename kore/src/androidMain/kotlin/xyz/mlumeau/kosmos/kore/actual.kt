package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl

actual fun platformName(): String {
    return "Android"
}

actual fun requestAPOD(
    apodRepositoryCache: APODRepositoryCacheImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
) {
    TODO("The Android app must use the suspend function instead.")
}