package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.model.APOD

interface APODRepositoryRemote {
    fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit)
}