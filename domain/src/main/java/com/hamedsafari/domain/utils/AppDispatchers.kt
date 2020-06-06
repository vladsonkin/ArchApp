package com.hamedsafari.domain.utils

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(val main: CoroutineDispatcher,
                     val io: CoroutineDispatcher)