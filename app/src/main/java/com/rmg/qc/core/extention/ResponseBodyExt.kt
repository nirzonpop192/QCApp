package com.rmg.qc.core.extention

import com.foodibd.rider.core.data.ErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody

/**
 * Getting exact Error Body Response from the API
 */
val ResponseBody?.errorMessage: ErrorResponse?
    get() {
        try {
            return Gson().fromJson<Any>(
                this!!.string(),
                ErrorResponse::class.java
            ) as? ErrorResponse
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }