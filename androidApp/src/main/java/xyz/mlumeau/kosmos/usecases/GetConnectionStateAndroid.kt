package xyz.mlumeau.kosmos.usecases

import android.net.ConnectivityManager
import android.net.NetworkInfo
import xyz.mlumeau.kosmos.kore.usecases.GetConnectionState

class GetConnectionStateAndroid(
    private val connectivityManager: ConnectivityManager
) : GetConnectionState {
    override fun isConnectedToNetwork(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }
}