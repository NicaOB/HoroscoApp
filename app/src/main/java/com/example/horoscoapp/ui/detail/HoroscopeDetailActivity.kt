package com.example.horoscoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscoapp.R
import com.example.horoscoapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscoapp.domain.model.HoroscopeId
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel by viewModels<HoroscopeDetailViewModel>()

    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener{onBackPressedDispatcher.onBackPressed()}
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when(state.horoscope){
            HoroscopeId.Aries -> R.drawable.detail_aries
            HoroscopeId.Taurus -> R.drawable.detail_taurus
            HoroscopeId.Gemini -> R.drawable.detail_gemini
            HoroscopeId.Cancer -> R.drawable.detail_cancer
            HoroscopeId.Leo -> R.drawable.detail_leo
            HoroscopeId.Virgo -> R.drawable.detail_virgo
            HoroscopeId.Libra -> R.drawable.detail_libra
            HoroscopeId.Scorpio -> R.drawable.detail_scorpio
            HoroscopeId.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeId.Capricorn -> R.drawable.detail_capricorn
            HoroscopeId.Aquarius -> R.drawable.detail_aquarius
            HoroscopeId.Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }
}