package com.rmg.qc.data.entity
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName




@Keep
data class LoginResponse(
    @SerializedName("Success")
    val success: Boolean? = null, // true
    @SerializedName("Message")
    val message: String? = null, // login successful
    @SerializedName("Payload")
    val payload: String? = null // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjE1MDU5OWRlLWEyNTgtNGU3YS1hYjkyLTYyMjBlNjY3YzYzMiIsIm5hbWVpZCI6IlN1cGVyQWRtaW4iLCJyb2xlIjoiQWRtaW4iLCJuYmYiOjE3MDM1MTI4MTEsImV4cCI6MTcwMzUxNDYxMSwiaWF0IjoxNzAzNTEyODExLCJpc3MiOiJodHRwczovL2xvY2FsaG9zdDo3MTkzLyIsImF1ZCI6Imh0dHA6Ly9sb2NhbGhvc3Q6NDIwMCJ9.pQ_3wXg2DvZeSp8G5f5MMSKW9S9_PSSWr31DPAgnHKw
)