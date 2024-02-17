package com.example.horoscoapp.ui.horoscope.rvData

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscoapp.R
import com.example.horoscoapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList:List<HoroscopeInfo> = emptyList()):RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope ,parent, false))
    }

    override fun getItemCount(): Int = this.horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(this.horoscopeList[position])
    }

    fun updateList(list: List<HoroscopeInfo>){
        this.horoscopeList = list
        notifyDataSetChanged()
    }
}