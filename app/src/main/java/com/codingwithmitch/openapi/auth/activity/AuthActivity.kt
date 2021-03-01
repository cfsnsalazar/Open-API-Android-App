package com.codingwithmitch.openapi.auth.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.openapi.R
import com.codingwithmitch.openapi.common.activity.BaseActivity

class AuthActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}