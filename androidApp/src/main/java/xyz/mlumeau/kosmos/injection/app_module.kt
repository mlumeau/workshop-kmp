package xyz.mlumeau.kosmos.injection

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import xyz.mlumeau.kosmos.viewmodel.ApodViewModel

/**
 * App Components
 */
val kosmosAppModule = module {
    viewModel { ApodViewModel(get()) }
}

val kosmosModules = listOf(kosmosAppModule, api_module)
