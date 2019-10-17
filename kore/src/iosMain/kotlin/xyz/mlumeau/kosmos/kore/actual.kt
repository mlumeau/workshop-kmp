package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.launch
import platform.UIKit.UIDevice
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}

actual fun requestAPOD(getAPODImpl: GetAPODImpl, completion: (APOD) -> Unit, failure: () -> Unit) {
    MainScope().launch {
        completion(getAPODImpl())
    }
}