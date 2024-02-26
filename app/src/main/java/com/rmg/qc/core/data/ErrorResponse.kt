package com.foodibd.rider.core.data

import com.google.gson.Gson
import okhttp3.ResponseBody

data class ErrorResponse(
    var errorCode:Int,
    var message:String
)

