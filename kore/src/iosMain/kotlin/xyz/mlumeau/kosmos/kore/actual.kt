package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import platform.UIKit.UIDevice
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl

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

actual fun getNetworkScope() = MainScope() as CoroutineScope

actual fun requestAPOD(getAPODImpl: GetAPODImpl, completion: (APOD) -> Unit, failure: () -> Unit) {
    MainScope().launch {
        val apod = getAPODImpl()
        if (apod != null) {
            completion(apod)
        } else {
            failure()
        }
    }
}