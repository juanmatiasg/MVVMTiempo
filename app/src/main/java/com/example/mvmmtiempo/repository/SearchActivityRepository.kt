package com.example.mvmmtiempo.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mvmmtiempo.network.BASE_URL
import com.example.mvmmtiempo.network.WeatherNetwork
import com.example.mvmmtiempo.network.model.Location
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository() {
    val showProgress = MutableLiveData<Boolean>()
    val locationList = MutableLiveData<List<Location>>()

    fun changeState() {
        if (showProgress.value != null && showProgress.value!!) {
            showProgress.value = false
        } else {
            showProgress.value = true
        }
    }

    fun searchLocation(searchString: String) {
        showProgress.value = true

        //Network Call
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getLocation(searchString).enqueue(object : Callback<List<Location>>{
            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                showProgress.value = false
            }

            override fun onResponse(
                call: Call<List<Location>>,
                response: Response<List<Location>>
            ) {
                Log.d("SearchRepository","Response:${Gson().toJson(response.body())}")
                locationList.value = response.body()
                showProgress.value = false
            }

        })
    }
}