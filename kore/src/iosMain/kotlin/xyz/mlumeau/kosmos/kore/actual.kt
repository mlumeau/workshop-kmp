package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import platform.UIKit.UIDevice
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl
import xyz.mlumeau.kosmos.kore.model.APOD

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

fun getNetworkScope() = MainScope() as CoroutineScope

actual fun requestAPOD(
    apodRepositoryRemote: APODRepositoryRemoteImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
) {
    getNetworkScope().launch {
        val apod = apodRepositoryRemote.getAPOD()
        if (apod != null) {
            completion(apod)
        } else {
            failure()
        }
    }
}

actual fun requestAPOD(
    apodRepositoryCache: APODRepositoryCacheImpl,
    completion: (APOD) -> Unit,
    failure: () -> Unit
) {
    MainScope().launch {
        val apod = apodRepositoryCache.getAPOD()
        if (apod != null) {
            completion(apod)
        } else {
            failure()
        }
    }
}