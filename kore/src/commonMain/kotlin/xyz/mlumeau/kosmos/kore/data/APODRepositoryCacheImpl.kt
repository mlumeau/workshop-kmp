package xyz.mlumeau.kosmos.kore.data

import kotlinx.serialization.json.Json
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.requestAPOD

class APODRepositoryCacheImpl : APODRepositoryCache {

    override suspend fun getAPOD(): APOD? = Json.nonstrict.parse(APOD.serializer(), APOD_STUB)

    override fun getAPOD(completion: (APOD) -> Unit, failure: () -> Unit) {
        requestAPOD(this, completion, failure)
    }

    companion object {
        private const val APOD_STUB =
            "{\"date\":\"2019-08-31\",\"explanation\":\"Few cosmic vistas excite the imagination like the Orion Nebula, an immense stellar nursery some 1,500 light-years away. Spanning about 40 light-years across the region, this infrared image from the Spitzer Space Telescope was constructed from data intended to monitor the brightness of the nebula's young stars, many still surrounded by dusty, planet-forming disks. Orion's young stars are only about 1 million years old, compared to the Sun's age of 4.6 billion years. The region's hottest stars are found in the Trapezium Cluster, the brightest cluster near picture center. Launched into orbit around the Sun on August 25, 2003 Spitzer's liquid helium coolant ran out in May 2009. The infrared space telescope continues to operate though, its mission scheduled to end on January 30, 2020. Recorded in 2010, this false color view is from two channels that still remain sensitive to infrared light at Spitzer's warmer operating temperatures.\",\"hdurl\":\"https://apod.nasa.gov/apod/image/1908/orion2010_spitzer.jpg\",\"media_type\":\"image\",\"service_version\":\"v1\",\"title\":\"Spitzer's Orion\",\"url\":\"https://apod.nasa.gov/apod/image/1908/orion2010_spitzerMedRC.jpg\"}"
    }
}