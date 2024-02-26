package com.foodibd.rider.util

import com.foodibd.rider.common.data.AndroidErrorResponse
import retrofit2.HttpException
import java.io.IOException

class ErrorUtil {

    companion object {
        fun exception(e: Exception): AndroidErrorResponse {

            val rValue = AndroidErrorResponse(0, "")

            if (e is HttpException) {

                val exception: HttpException = e as HttpException

                when (exception.code()) {
                    400 -> {
                        return AndroidErrorResponse(400, "Validation Error")
                    }

                    401 -> {
                        return AndroidErrorResponse(401, "Invalid Token! Permission denied")
                    }

                    500 -> {
                        return AndroidErrorResponse(500, "Internal Server Error")
                    }

                    403 -> {
                        return AndroidErrorResponse(403, "Forbidden! Access Denied")
                    }

                    else -> {
                        return AndroidErrorResponse(401, exception.message.toString())
                    }
                }
            } else if (e is IOException) {
                val exception: IOException = e as IOException
                return AndroidErrorResponse(
                    1, exception.message.toString() + " Could not reach " +
                            "the server. Please check your internet"
                )
            } else if (e is IOException) {
                return AndroidErrorResponse(1, e.message.toString())
            }
            return rValue
        }

    }


}