package com.example.mvmmtiempo.network

import com.example.mvmmtiempo.network.model.Location
import com.example.mvmmtiempo.network.model.WheaterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://www.metaweather.com/api/location/"

interface WeatherNetwork {
    @GET("search?")
    fun getLocation(@Query("query")searchString:String): Call<List<Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid")woeid:Int):Call<WheaterResponse>
}