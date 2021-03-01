package com.codingwithmitch.openapi.auth.repository

import com.codingwithmitch.openapi.auth.api.OpenApiAuthService
import com.codingwithmitch.openapi.auth.persistence.AccountPropertiesDao
import com.codingwithmitch.openapi.auth.persistence.AuthTokenDao
import com.codingwithmitch.openapi.common.SessionManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    authTokenDao: AuthTokenDao,
    accountPropertiesDao: AccountPropertiesDao,
    openApiAuthService: OpenApiAuthService,
    sessionManager: SessionManager
)