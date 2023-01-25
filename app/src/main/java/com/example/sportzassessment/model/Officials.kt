package com.example.sportzassessment.model

import com.google.gson.annotations.SerializedName

data class Officials(
    @SerializedName("Umpires" ) var Umpires : String? = null,
    @SerializedName("Referee" ) var Referee : String? = null

): java.io.Serializable

