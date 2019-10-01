package xyz.mlumeau.kosmos.usecases

import xyz.mlumeau.kosmos.kore.APOD

interface GetAPOD {
    suspend operator fun invoke(): APOD?
    fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit)
}