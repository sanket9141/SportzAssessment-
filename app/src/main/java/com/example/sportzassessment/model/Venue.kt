package com.example.sportzassessment.model

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("Id"   ) var Id   : String? = null,
    @SerializedName("Name" ) var Name : String? = null
): java.io.Serializable
