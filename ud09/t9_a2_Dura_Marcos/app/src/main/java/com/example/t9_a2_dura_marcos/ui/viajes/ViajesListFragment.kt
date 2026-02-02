package com.example.t9_a2_dura_marcos.ui.viajes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t9_a2_dura_marcos.R
import com.example.t9_a2_dura_marcos.data.Destino
import com.example.t9_a2_dura_marcos.data.IDestinoDAO
import com.example.t9_a2_dura_marcos.data.IViajeDAO
import com.example.t9_a2_dura_marcos.data.IViajesConDestinoDAO
import com.example.t9_a2_dura_marcos.data.Viaje
import com.example.t9_a2_dura_marcos.data.ViajeApplication
import com.example.t9_a2_dura_marcos.data.ViajeConDestino
import com.example.t9_a2_dura_marcos.databinding.FragmentViajesListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViajesListFragment : Fragment(R.layout.fragment_viajes_list) {

    private lateinit var binding: FragmentViajesListBinding
    private lateinit var viajeConDestinoDao: IViajesConDestinoDAO
    private lateinit var viajeDao: IViajeDAO
    private lateinit var destinoDao: IDestinoDAO
    private lateinit var adapterViaje: ViajeAdapter

    private var listaViajes: MutableList<ViajeConDestino> = mutableListOf()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentViajesListBinding.bind(view)
        viajeConDestinoDao = ViajeApplication.database.viajeConDestinoDao()
        destinoDao = ViajeApplication.database.destinoDao()
        viajeDao = ViajeApplication.database.viajeDao()

        setupRecyclerView()
        cargarViajes()
    }

    private fun setupRecyclerView() {

        adapterViaje = ViajeAdapter(listaViajes) { viaje -> eliminarViaje(viaje) }
        binding.recyclerViewViajes.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewViajes.adapter = adapterViaje

    }

    private fun cargarViajes() {
        lifecycleScope.launch {
            val listaViajes = withContext(Dispatchers.IO) {
                viajeConDestinoDao.getViajesConDestino()
            }

            adapterViaje.actualizarViajes(listaViajes)
        }
    }

    private fun eliminarViaje(viaje: Viaje) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                viajeDao.delete(viaje)
            }
            cargarViajes()
        }
    }

}