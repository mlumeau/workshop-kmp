package xyz.mlumeau.kosmos.kore.usecases

import xyz.mlumeau.kosmos.kore.model.APOD

interface GetAPOD {
    fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit)
}