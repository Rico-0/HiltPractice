package com.jhhong.hiltpractice.service

import com.jhhong.hiltpractice.data.Constants.AUTH_KEY
import com.jhhong.hiltpractice.data.PlaceData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("15091348/v1/uddi:b7b5aaba-9baf-4f81-aefd-a3d87daf1974")
    suspend fun getAllPlaces(
        @Query ("serviceKey") serviceKey : String, // service key
        @Query("page") page : Int, // page index
        @Query ("perPage") pageSize : Int, // page size
        @Query ("returnType") returnType : String // default : JSON
    ) : Response<PlaceData>
}