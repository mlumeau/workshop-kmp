package xyz.mlumeau.kosmos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.mlumeau.kosmos.kore.APOD
import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

class APODViewModel : ScopedViewModel() {

    private val nasaAPI: NasaApi = NasaAPIRemote()
    private var job: Job? = null

    private val _apod = MutableLiveData<APOD>()
    val apod: LiveData<APOD>
        get() = _apod

    init {
        job = nasaAPI.getAPOD { apod ->
            launch {
                _apod.value = apod
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}