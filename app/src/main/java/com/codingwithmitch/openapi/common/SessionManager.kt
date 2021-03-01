package com.codingwithmitch.openapi.common

import android.app.Application
import com.codingwithmitch.openapi.auth.persistence.AuthTokenDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(app: Application, authTokenDao: AuthTokenDao) {

}