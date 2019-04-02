package xyz.mlumeau.kosmos.kore


expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}

internal fun helloCoroutine() {
    println("Hello Coroutines!")
}
