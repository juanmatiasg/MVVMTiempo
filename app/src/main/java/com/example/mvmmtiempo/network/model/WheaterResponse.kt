package com.example.mvmmtiempo.network.model

data class WheaterResponse(
    val consolidated_weather: List<ConsolidatedWeather>,
    val time: String,
    val title: String,
    val woeid: Int
)