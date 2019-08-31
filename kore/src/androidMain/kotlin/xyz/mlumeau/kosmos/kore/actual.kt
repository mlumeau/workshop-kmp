package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl

actual fun platformName(): String {
    return "Android"
}

actual fun getNetworkScope(): CoroutineScope {
    return CoroutineScope(Dispatchers.IO)
}

actual fun isConnected() = true

actual fun requestAPOD(getAPODImpl: GetAPODImpl, completion: (APOD) -> Unit, failure: () -> Unit) {
    TODO("The Android app must use the suspend function instead.")
}