package com.codingwithmitch.openapi.auth.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingwithmitch.openapi.auth.models.AccountProperties

@Dao
interface AccountPropertiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(accountPropertiesDao: AccountProperties): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnore(accountPropertiesDao: AccountProperties): Long

    @Query(value = "SELECT * FROM account_properties WHERE pk = :pk ")
    fun searchByPk(pk: Int): AccountProperties?

    @Query(value = "SELECT * FROM account_properties WHERE email = :email ")
    fun searchByEmail(email: String): AccountProperties?

}