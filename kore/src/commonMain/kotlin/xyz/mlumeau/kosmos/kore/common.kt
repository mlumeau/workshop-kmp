package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl


expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

internal fun helloCoroutine() {
    println("Hello Coroutines!")
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