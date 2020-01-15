package xyz.mlumeau.kosmos.kore.model

import kotlinx.serialization.Serializable

@Serializable
data class APOD(
    val explanation: String? = null,
    val media_type: String? = null,
    val title : String? = null,
    val url: String? = null
)