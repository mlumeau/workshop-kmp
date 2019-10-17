package xyz.mlumeau.kosmos.kore

import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl


expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

expect fun requestAPOD(getAPODImpl: GetAPODImpl, completion: (APOD) -> Unit, failure: () -> Unit)