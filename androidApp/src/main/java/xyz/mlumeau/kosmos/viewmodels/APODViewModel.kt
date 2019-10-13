package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.usecases.GetAPOD

class APODViewModel(
    private val getApodUseCase: GetAPOD
) : ScopedViewModel() {

    private var job: Job? = null

    private val _apod = MutableLiveData<APOD>()
    val apod: LiveData<APOD>
        get() = _apod

    init {
        startLoadingData()
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    private fun startLoadingData() {
        launch {
            val apod = getApodUseCase()
            withContext(Dispatchers.Main) {
                _apod.value = apod
            }
        }
    }
}