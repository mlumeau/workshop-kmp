package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.launch
import platform.UIKit.UIDevice
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl
import xyz.mlumeau.kosmos.kore.model.APOD

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

fun showHelloCoroutine() {
    MainScope().launch {
        helloCoroutine()
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