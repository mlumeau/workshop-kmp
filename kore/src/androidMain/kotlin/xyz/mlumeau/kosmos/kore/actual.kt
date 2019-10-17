package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl

actual fun platformName(): String {
    return "Android"
}

actual fun requestAPOD(getAPODImpl: GetAPODImpl, completion: (APOD) -> Unit, failure: () -> Unit) {
    TODO("The Android app must use the suspend function instead.")
}