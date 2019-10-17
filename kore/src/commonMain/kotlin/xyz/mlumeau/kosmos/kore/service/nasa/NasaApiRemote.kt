package xyz.mlumeau.kosmos.kore.service.nasa

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.response.readText
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import xyz.mlumeau.kosmos.kore.model.APOD


internal class NasaAPIRemote(
    private val client: HttpClient = HttpClient()
) : NasaApi {

    private suspend fun request(urlString: String): String {
        return client.call(urlString) {
            method = HttpMethod.Get
        }.response.readText()
    }

    private suspend fun requestAPOD() : APOD {
        val result = request(APOD_URL)

        return Json.nonstrict.parse(APOD.serializer(), result)
    }

    override suspend fun getAPOD(): APOD = requestAPOD()

    companion object {
        const val APOD_URL = "https://api.nasa.gov/planetary/apod?&api_key=DEMO_KEY"
    }
}