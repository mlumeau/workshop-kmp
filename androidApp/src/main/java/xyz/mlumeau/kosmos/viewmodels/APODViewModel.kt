package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.usecases.GetAPOD

class APODViewModel(
    private val getApodUseCase: GetAPOD
) : ViewModel() {

    private val _apod = MutableLiveData<APOD>()
    val apod: LiveData<APOD>
        get() = _apod

    init {
        startLoadingData()
    }

    private fun startLoadingData() {
        getApodUseCase.getAPOD(
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