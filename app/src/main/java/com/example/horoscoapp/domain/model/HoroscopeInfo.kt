package com.example.horoscoapp.domain.model

import com.example.horoscoapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int, val id:HoroscopeId){
    data object Aries:HoroscopeInfo(R.drawable.aries, R.string.aries, HoroscopeId.Aries)
    data object Taurus: HoroscopeInfo(R.drawable.tauro, R.string.taurus,HoroscopeId.Taurus)
    data object Gemini: HoroscopeInfo(R.drawable.geminis, R.string.gemini, HoroscopeId.Gemini)
    data object Cancer: HoroscopeInfo(R.drawable.cancer, R.string.cancer, HoroscopeId.Cancer)
    data object Leo: HoroscopeInfo(R.drawable.leo, R.string.leo, HoroscopeId.Leo)
    data object Virgo: HoroscopeInfo(R.drawable.virgo, R.string.virgo, HoroscopeId.Virgo)
    data object Libra: HoroscopeInfo(R.drawable.libra, R.string.libra, HoroscopeId.Libra)
    data object Scorpio: HoroscopeInfo(R.drawable.escorpio, R.string.scorpio, HoroscopeId.Scorpio)
    data object Sagittarius: HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius, HoroscopeId.Sagittarius)
    data object Capricorn: HoroscopeInfo(R.drawable.capricornio, R.string.capricorn, HoroscopeId.Capricorn)
    data object Aquarius: HoroscopeInfo(R.drawable.aquario, R.string.aquarius, HoroscopeId.Aquarius)
    data object Pisces: HoroscopeInfo(R.drawable.piscis, R.string.pisces, HoroscopeId.Pisces)
}
