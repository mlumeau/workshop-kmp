package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal expect val coroutineScope: CoroutineScope

internal abstract class Scope(
    private val dispatcher: CoroutineDispatcher
) : CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job

}