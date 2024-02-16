package com.example.horoscoapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.horoscoapp.databinding.FragmentHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.Console

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {


    /*
    Esta línea está creando una variable horoscopeViewModel que es una instancia de HoroscopeViewModel.
     Aquí es donde entra en juego la función viewModels<>() de Android, que se utiliza para obtener una referencia a un ViewModel.

    La palabra clave by en Kotlin se utiliza para la delegación de propiedades. En este caso, está delegando la inicialización y la gestión
     de la variable horoscopeViewModel a la función viewModels<>(). Esto significa que viewModels<>() se encargará de crear el ViewModel cuando
      se necesite y de manejar su ciclo de vida correctamente.

        En resumen, esta línea de código está creando un ViewModel que se utilizará en el contexto de una Activity o Fragment, y delega la
         responsabilidad de su inicialización y manejo a la función viewModels<>(). Esto permite que los datos del ViewModel sobrevivan
          a los cambios de configuración (como las rotaciones de pantalla) y se mantengan disponibles mientras la Activity o Fragment esté en memoria.
    */

    private val horocospeViewModel by viewModels<HoroscopeViewModel>()

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horocospeViewModel.horoscope.collect{

                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}