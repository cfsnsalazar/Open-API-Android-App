package com.codingwithmitch.openapi.common.di

import com.codingwithmitch.openapi.auth.activity.AuthActivity
import com.codingwithmitch.openapi.auth.di.AuthFragmentBuilderModule
import com.codingwithmitch.openapi.auth.di.AuthModule
import com.codingwithmitch.openapi.auth.di.AuthScope
import com.codingwithmitch.openapi.auth.di.AuthViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuilderModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}