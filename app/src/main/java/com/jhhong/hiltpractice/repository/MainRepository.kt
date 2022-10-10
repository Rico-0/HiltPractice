package com.jhhong.hiltpractice.repository

import com.jhhong.hiltpractice.data.Constants.AUTH_KEY
import com.jhhong.hiltpractice.service.ApiService
import com.jhhong.hiltpractice.util.DecodeApiKey
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllPlaces(page : Int, perPage : Int)
        = apiService.getAllPlaces(DecodeApiKey.decode(), page, perPage, returnType = "JSON")
}