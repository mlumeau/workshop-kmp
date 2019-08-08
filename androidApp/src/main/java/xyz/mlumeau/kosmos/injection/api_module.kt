package xyz.mlumeau.kosmos.injection

import org.koin.dsl.module
import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

val api_module = module {

    single<NasaApi> { NasaAPIRemote() }
}
