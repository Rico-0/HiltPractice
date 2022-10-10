package com.jhhong.hiltpractice.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("데이터기준일자")
    @Expose
    val dataDate : String,

    @SerializedName("소재지")
    @Expose
    val address : String,

    @SerializedName("업체명")
    @Expose
    val placeName : String,

    @SerializedName("연번")
    @Expose
    val placeIndex : String
)
