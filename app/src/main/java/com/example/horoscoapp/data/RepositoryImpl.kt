package com.example.horoscoapp.data

import android.util.Log
import com.example.horoscoapp.data.network.HoroscopeApiService
import com.example.horoscoapp.data.network.response.PredictionResponse
import com.example.horoscoapp.domain.Repository
import com.example.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) :Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {
        runCatching { apiService.getHoroscope(sign)}
            .onSuccess { return it.toDomain() }
            .onFailure { Log.d("apiService_error", "Ocurrio un problema ${it.message}") }
        return null
    }
}