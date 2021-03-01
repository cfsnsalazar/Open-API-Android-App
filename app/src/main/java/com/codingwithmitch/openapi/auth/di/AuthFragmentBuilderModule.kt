package com.codingwithmitch.openapi.auth.di

import com.codingwithmitch.openapi.auth.fragment.ForgotPasswordFragment
import com.codingwithmitch.openapi.auth.fragment.LauncherFragment
import com.codingwithmitch.openapi.auth.fragment.LoginFragment
import com.codingwithmitch.openapi.auth.fragment.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contributeForgotPasswordFragment(): ForgotPasswordFragment

}