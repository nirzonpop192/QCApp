package com.rmg.qc.core.extention


import android.util.Log
import com.rmg.qc.BuildConfig


fun String.debugLog(tag:String="dim") {
    if (BuildConfig.DEBUG)
        Log.d(tag,this)

}

fun String.responseLog(tag:String="response") {
    if (BuildConfig.DEBUG)
        Log.d(tag,this)

}

fun String.errorLog(tag:String="dim_error") {
    if (BuildConfig.DEBUG)
        Log.e(tag,this)

}

fun String. warnLog(tag:String="dim_warn") {
    if (BuildConfig.DEBUG)
        Log.w(tag,this)

}