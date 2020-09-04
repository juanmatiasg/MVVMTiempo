package com.example.mvmmtiempo.repository

import androidx.lifecycle.MutableLiveData
import com.example.mvmmtiempo.network.BASE_URL
import com.example.mvmmtiempo.network.WeatherNetwork
import com.example.mvmmtiempo.network.model.WheaterResponse
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivityRepository {
    val showProgress = MutableLiveData<Boolean>()
    val response = MutableLiveData<WheaterResponse>()

    fun getWheather(woeid:Int){
        showProgress.value = true

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getWeather(woeid).enqueue(object :Callback<WheaterResponse>{
            override fun onFailure(call: Call<WheaterResponse>, t: Throwable) {
                showProgress.value = false
            }

            override fun onResponse(
                call: Call<WheaterResponse>,
                res: Response<WheaterResponse>
            ) {
                response.value = res.body()
                showProgress.value = false

            }

        })
    }
}