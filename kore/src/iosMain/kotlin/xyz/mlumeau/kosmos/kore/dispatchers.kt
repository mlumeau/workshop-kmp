package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext


internal class MainDispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            block.run()
        }
    }
}

internal abstract class Scope(
    private val dispatcher: CoroutineDispatcher
) : CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job

}

internal class MainScope : Scope(MainDispatcher())