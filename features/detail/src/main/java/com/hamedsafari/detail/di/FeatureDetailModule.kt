package com.hamedsafari.detail.di

import com.hamedsafari.detail.DetailImageViewModel
import com.hamedsafari.detail.DetailViewModel
import com.hamedsafari.domain.usecase.detail.GetUserDetailUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureDetailModule = module {
    factory { GetUserDetailUseCase(get()) }
    viewModel { (argsLogin: String) -> DetailViewModel(get(), get(), argsLogin) }
    viewModel { (argsImageUrl: String) ->DetailImageViewModel(argsImageUrl) }
}