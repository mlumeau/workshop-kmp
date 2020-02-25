package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemote
import xyz.mlumeau.kosmos.kore.model.APOD

class APODViewModel(
    private val apodRepository: APODRepositoryRemote
) : ViewModel() {

    private val _apod = MutableLiveData<APOD>()
    val apod: LiveData<APOD>
        get() = _apod

    init {
        startLoadingData()
    }

    private fun startLoadingData() {
        apodRepository.getAPOD(
            this::onAPODLoaded,
            this::onAPODLoadingError
        )
    }

    private fun onAPODLoaded(apod: APOD) {
        _apod.postValue(apod)
    }

    private fun onAPODLoadingError() {
        // Handle the error
    }
}