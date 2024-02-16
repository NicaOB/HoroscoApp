package com.example.horoscoapp.ui.horoscope.rvData

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscoapp.databinding.ItemHoroscopeBinding
import com.example.horoscoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view : View) : RecyclerView.ViewHolder(view){

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo){
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = binding.tvHoroscope.context.getString(horoscopeInfo.name)
    }
}