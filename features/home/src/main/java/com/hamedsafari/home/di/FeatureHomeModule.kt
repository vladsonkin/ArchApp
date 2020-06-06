package com.hamedsafari.home.di

import com.hamedsafari.home.HomeViewModel
import com.hamedsafari.domain.usecase.home.GetTopUsersUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureHomeModule = module {
    factory { GetTopUsersUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}