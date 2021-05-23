package com.example.esiea3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorApi {
    @GET("colors/?format=json")
    fun getColorList(): Call<List<ColorListResponse>>
    fun getColorDetail(): Call<List<ColorDetailResponse>>
}