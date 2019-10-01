package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl


expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

internal fun helloCoroutine() {
    println("Hello Coroutines!")
}

expect fun requestAPOD(
    apodRepositoryCache: APODRepositoryCacheImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
)