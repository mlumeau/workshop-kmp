package xyz.mlumeau.kosmos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl

class APODViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == APODViewModel::class.java) { "Unknown ViewModel class" }
        return APODViewModel(
            APODRepositoryRemoteImpl()
        ) as T
    }
}