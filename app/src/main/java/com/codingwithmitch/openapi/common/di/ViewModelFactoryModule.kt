package com.codingwithmitch.openapi.common.di

import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.openapi.common.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}