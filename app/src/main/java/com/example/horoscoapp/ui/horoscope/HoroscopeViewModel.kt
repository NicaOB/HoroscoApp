package com.example.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(): ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList()) //mutable
    var horoscope : MutableStateFlow<List<HoroscopeInfo>> = _horoscope //no mutable y accesible

}