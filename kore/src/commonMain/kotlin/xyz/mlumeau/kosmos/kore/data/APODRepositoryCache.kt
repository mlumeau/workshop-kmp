package xyz.mlumeau.kosmos.kore.data

import xyz.mlumeau.kosmos.kore.model.APOD

interface APODRepositoryCache {
    fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit)
}