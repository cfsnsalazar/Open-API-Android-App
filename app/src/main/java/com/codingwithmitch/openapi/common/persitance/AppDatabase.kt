package com.codingwithmitch.openapi.common.persitance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codingwithmitch.openapi.auth.models.AccountProperties
import com.codingwithmitch.openapi.auth.models.AuthToken
import com.codingwithmitch.openapi.auth.persistence.AccountPropertiesDao
import com.codingwithmitch.openapi.auth.persistence.AuthTokenDao

@Database(entities = [ AuthToken::class, AccountProperties::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAuthTokenDao(): AuthTokenDao
    abstract fun getAccountPropertiesDao(): AccountPropertiesDao

    companion object {
        const val DATABASE_NAME = "app_db"
    }
}