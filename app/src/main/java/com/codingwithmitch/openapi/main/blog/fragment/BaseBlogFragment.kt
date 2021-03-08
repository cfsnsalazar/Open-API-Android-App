package com.codingwithmitch.openapi.main.blog.fragment

import android.content.Context
import android.util.Log
import com.codingwithmitch.openapi.common.ui.DataStateChangeListener
import dagger.android.support.DaggerFragment


abstract class BaseBlogFragment : DaggerFragment(){

    val TAG: String = "AppDebug"

    lateinit var stateChangeListener: DataStateChangeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            stateChangeListener = context as DataStateChangeListener
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement DataStateChangeListener" )
        }
    }
}