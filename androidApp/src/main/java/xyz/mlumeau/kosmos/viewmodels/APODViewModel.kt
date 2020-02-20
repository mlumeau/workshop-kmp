package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemote

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
        viewModelScope.launch {
            apodRepository.getAPOD()?.let { apod ->
                _apod.value = apod
            }
        }
    }
}