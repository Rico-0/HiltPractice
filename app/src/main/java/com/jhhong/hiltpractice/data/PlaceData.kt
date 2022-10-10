package com.jhhong.hiltpractice.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @SerialzedName : JSON으로 serialize 될 때 매칭되는 이름을 명시하는 목적으로 사용되는 field 마킹 어노테이션
 * @Expose : object 중 해당 값이 null일 경우, json으로 만들 필드를 자동 생략
 */
data class PlaceData(
   @SerializedName("currentCount")
   @Expose
   val currentCount : Int,

   @SerializedName("data")
   @Expose
   val places : List<Place>,

   @SerializedName("matchCount")
   @Expose
   val matchCount : Int,

   @SerializedName("page")
   @Expose
   val pageIndex : Int,

   @SerializedName("perPage")
   @Expose
   val perPage : Int,

   @SerializedName("totalCount")
   @Expose
   val totalCount : Int
)
