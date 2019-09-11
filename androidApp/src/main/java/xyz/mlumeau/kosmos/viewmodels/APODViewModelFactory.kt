package xyz.mlumeau.kosmos.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.mlumeau.kosmos.kore.usecases.GetConnectionState
import xyz.mlumeau.kosmos.kore.usecases.implementations.GetAPODImpl
import xyz.mlumeau.kosmos.usecases.GetConnectionStateAndroid

class APODViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == APODViewModel::class.java) { "Unknown ViewModel class" }
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val getConnectionState: GetConnectionState = GetConnectionStateAndroid(connectivityManager)
        return APODViewModel(
            GetAPODImpl(getConnectionState)
        ) as T
    }
}