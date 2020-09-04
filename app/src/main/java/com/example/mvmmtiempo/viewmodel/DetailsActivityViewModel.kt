package com.example.mvmmtiempo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvmmtiempo.network.model.WheaterResponse
import com.example.mvmmtiempo.repository.DetailsActivityRepository

class DetailsActivityViewModel():ViewModel(){

    private val repository = DetailsActivityRepository()
    val showProgress: LiveData<Boolean>
    val response: LiveData<WheaterResponse>

    init {
        this.showProgress = repository.showProgress
        this.response = repository.response
    }

    fun getWheater(woeId:Int){
        repository.getWheather(woeId)
    }


}