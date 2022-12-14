package com.viatom.blood.ui.dashboard

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.viatom.blood.databinding.Lpm311FragmentDashboardBinding
import com.viatom.blood.ui.dashboard.adapter.*
import com.viatom.blood.BleServer.dataScope
import com.viatom.blood.net.NetCmd
import com.viatom.blood.net.NetCmd.url
import com.viatom.blood.net.SimpleHttpServer
import com.viatom.blood.utils.PathUtil
import kotlinx.coroutines.*
import java.io.ByteArrayInputStream
import java.io.File

class LPM311DashboardFragment : Fragment() {

    private var _binding: Lpm311FragmentDashboardBinding? = null


    private val binding get() = _binding!!
    private lateinit var dataAdapter: LPMRealTimeDataAdapter




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Lpm311FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        dataAdapter= LPMRealTimeDataAdapter(requireContext())


        dataScope.launch {
            val httpsServer = SimpleHttpServer()
            httpsServer.Start(13207)
        }

        binding.getImg.setOnClickListener {

        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}