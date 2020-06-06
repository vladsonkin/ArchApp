package com.hamedsafari.repository.di

import com.hamedsafari.domain.repositories.UserRepository
import com.hamedsafari.domain.utils.AppDispatchers
import com.hamedsafari.repository.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        AppDispatchers(
            Dispatchers.Main,
            Dispatchers.IO
        )
    }
    factory { UserRepositoryImpl(
        get(),
        get()
    ) as UserRepository
    }
}