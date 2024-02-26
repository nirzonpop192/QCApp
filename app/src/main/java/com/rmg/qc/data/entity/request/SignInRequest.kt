package com.rmg.qc.data.entity.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("UserName")
    val userName: String = "sandeep@mahfuj.site", // true
    @SerializedName("Password")
    val password: String? = "Tusuka@123"
)
