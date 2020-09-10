package com.ankit.jare.model.api

import com.ankit.jare.model.ListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("search?term=all")
    fun getList(): Call<ListResponse>
}