package com.example.sportzassessment.model

import com.google.gson.annotations.SerializedName

data class Newzeland(
    @SerializedName("Name_Full"  ) var NameFull  : String?  = null,
    @SerializedName("Name_Short" ) var NameShort : String?  = null,
    @SerializedName("Players") val Player: Map<String, PlayerDetail>? = null
): java.io.Serializable

