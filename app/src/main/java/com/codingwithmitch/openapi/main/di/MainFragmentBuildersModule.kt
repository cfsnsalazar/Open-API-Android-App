package com.codingwithmitch.openapi.main.di

import com.codingwithmitch.openapi.main.account.fragment.AccountFragment
import com.codingwithmitch.openapi.main.account.fragment.ChangePasswordFragment
import com.codingwithmitch.openapi.main.account.fragment.UpdateAccountFragment
import com.codingwithmitch.openapi.main.blog.fragment.BlogFragment
import com.codingwithmitch.openapi.main.blog.fragment.UpdateBlogFragment
import com.codingwithmitch.openapi.main.blog.fragment.ViewBlogFragment
import com.codingwithmitch.openapi.main.create_blog.fragment.CreateBlogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeBlogFragment(): BlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector()
    abstract fun contributeChangePasswordFragment(): ChangePasswordFragment

    @ContributesAndroidInjector()
    abstract fun contributeCreateBlogFragment(): CreateBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeUpdateBlogFragment(): UpdateBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeViewBlogFragment(): ViewBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeUpdateAccountFragment(): UpdateAccountFragment

}