package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual fun platformName(): String {
    return "Android"
}

actual fun getNetworkScope(): CoroutineScope {
    return CoroutineScope(Dispatchers.IO)
}
