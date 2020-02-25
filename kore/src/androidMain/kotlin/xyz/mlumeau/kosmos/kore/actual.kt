package xyz.mlumeau.kosmos.kore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal actual val coroutineScope = IOScope() as CoroutineScope

internal class IOScope : Scope(Dispatchers.IO)