package com.codingwithmitch.openapi.auth.di

import androidx.lifecycle.ViewModel
import com.codingwithmitch.openapi.auth.viewModel.AuthViewModel
import com.codingwithmitch.openapi.common.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel


}