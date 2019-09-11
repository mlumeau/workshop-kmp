package xyz.mlumeau.kosmos.kore.usecases

interface GetConnectionState {
    fun isConnectedToNetwork(): Boolean
}