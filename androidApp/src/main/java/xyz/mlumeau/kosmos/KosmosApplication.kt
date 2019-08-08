package xyz.mlumeau.kosmos

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import xyz.mlumeau.kosmos.injection.kosmosModules

class KosmosApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KosmosApplication)
            modules(kosmosModules)
        }
    }
}