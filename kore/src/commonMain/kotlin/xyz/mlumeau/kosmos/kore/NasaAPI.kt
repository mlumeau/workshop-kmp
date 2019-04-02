package xyz.mlumeau.kosmos.kore

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.response.readText
import io.ktor.http.HttpMethod
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


class NasaAPI {
    private val client = HttpClient()


    private suspend fun request(urlString: String): String {
        return client.call(urlString) {
            method = HttpMethod.Get
        }.response.readText()
    }

    private suspend fun requestAPOD() : APOD {

        val result = request(APOD_URL)

        return Json.nonstrict.parse(APOD.serializer(), result)
    }

    fun getAPOD(completion: (APOD) -> Unit) : Job {

        return getNetworkScope().launch {
            completion(requestAPOD())
        }
    }

    companion object {
        const val APOD_URL = "https://api.nasa.gov/planetary/apod?&api_key=DEMO_KEY"
    }
}

expect fun getNetworkScope() : CoroutineScope