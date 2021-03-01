package com.codingwithmitch.openapi.auth.models

import android.accounts.Account
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "auth_token",
    foreignKeys = [
        ForeignKey(
            entity = AccountProperties::class,
            parentColumns = ["pk"],
            childColumns = ["account_pk"],
            onDelete = CASCADE
        )
    ]
)
data class AuthToken(
    @PrimaryKey
    @ColumnInfo(name = "account_pk")
    var account_pk: Int? = -1,

    @SerializedName(value = "token")
    @Expose
    @ColumnInfo(name = "token")
    var token: String? = null

)