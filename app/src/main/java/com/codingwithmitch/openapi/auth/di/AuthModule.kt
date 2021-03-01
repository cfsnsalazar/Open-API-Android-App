package com.codingwithmitch.openapi.auth.di

import com.codingwithmitch.openapi.auth.api.OpenApiAuthService
import com.codingwithmitch.openapi.auth.persistence.AccountPropertiesDao
import com.codingwithmitch.openapi.auth.persistence.AuthTokenDao
import com.codingwithmitch.openapi.auth.repository.AuthRepository
import com.codingwithmitch.openapi.common.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideFakeApiService(): OpenApiAuthService {
        return Retrofit.Builder().baseUrl("https://open-api.xyz").build()
            .create(OpenApiAuthService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao, accountPropertiesDao, openApiAuthService, sessionManager
        )
    }
}