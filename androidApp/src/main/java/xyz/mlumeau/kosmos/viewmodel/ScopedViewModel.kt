package xyz.mlumeau.kosmos.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class ScopedViewModel: ViewModel(), CoroutineScope {
    private val job = Job()
    val parentJob: Job
        get() = job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}