package com.example.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscoapp.data.providers.HoroscopeProvider
import com.example.horoscoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList()) //mutable
    var horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope //no mutable y accesible

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}