package com.example.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscoapp.data.providers.HoroscopeProvider
import com.example.horoscoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var horoscope: List<HoroscopeInfo>

    init {
        horoscope = horoscopeProvider.getHoroscopes()
    }

    fun getHoroscope(): List<HoroscopeInfo> {
        return this.horoscope
    }

}