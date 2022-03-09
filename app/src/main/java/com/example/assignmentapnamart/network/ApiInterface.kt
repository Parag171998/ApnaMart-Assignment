package com.example.assignmentapnamart.network

import com.example.assignmentapnamart.models.ResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/list")
    suspend fun getData(@Query("page") page:String,  @Query("limit") number: String): Response<ResponseData>
}