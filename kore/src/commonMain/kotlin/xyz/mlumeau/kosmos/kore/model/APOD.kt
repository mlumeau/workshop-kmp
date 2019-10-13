package xyz.mlumeau.kosmos.kore.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class APOD(
    @Optional val explanation: String? = null,
    @Optional val media_type: String? = null,
    @Optional val title : String? = null,
    @Optional val url: String? = null
)