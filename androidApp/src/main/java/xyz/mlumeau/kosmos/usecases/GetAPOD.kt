package xyz.mlumeau.kosmos.usecases

import kotlinx.coroutines.Job
import xyz.mlumeau.kosmos.kore.APOD

interface GetAPOD {
    operator fun invoke(completion: (APOD) -> Unit): Job
}