package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            getApodUseCase()?.let { apod ->
                _apod.value = apod
            }
        }
    }
}