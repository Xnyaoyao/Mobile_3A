package com.example.esiea3a.presentation

import com.example.esiea3a.presentation.api.ColorApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object {
        val colorApi : ColorApi = Retrofit.Builder()
                .baseUrl("http://www.colourlovers.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ColorApi::class.java)
    }
}