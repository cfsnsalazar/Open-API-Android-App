package com.codingwithmitch.openapi.common

import android.app.Application
import com.codingwithmitch.openapi.auth.persistence.AuthTokenDao

class SessionManager(app: Application, authTokenDao: AuthTokenDao)