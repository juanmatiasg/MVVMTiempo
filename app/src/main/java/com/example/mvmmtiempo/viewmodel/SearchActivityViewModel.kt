package com.example.mvmmtiempo.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvmmtiempo.network.model.Location
import com.example.mvmmtiempo.repository.SearchActivityRepository

/*En nuestro caso necesitamos un contexto */
/*Para SearchActivity necesitamos un Repositorio*/


class SearchActivityViewModel:ViewModel(){
    private val repository = SearchActivityRepository()
    val showProgress:LiveData<Boolean>
    val locationList:LiveData<List<Location>>

    init {
        this.showProgress = repository.showProgress
        this.locationList = repository.locationList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchLocation(searchString:String){
        repository.searchLocation(searchString)
    }

}
