package com.vaca.pc300.ui.history.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaca.pc300.databinding.FragmentHistoryBinding
import com.vaca.pc300.databinding.FragmentHistoryGluBinding
import com.vaca.pc300.ui.dashboard.adapter.PC300DataDetailAdapter
import com.vaca.pc300.ui.dashboard.adapter.SpaceItemDecoration3
import com.vaca.pc300.ui.history.HistoryViewModel
import com.vaca.pc300.ui.history.adapter.PC300HistoryLeftAdapter

class PC300HistoryGluFragment : Fragment() {

    private var _binding: FragmentHistoryGluBinding? = null


    private val binding get() = _binding!!

    private lateinit var leftAdapter: PC300HistoryLeftAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHistoryGluBinding.inflate(inflater, container, false)
        val root: View = binding.root

        leftAdapter= PC300HistoryLeftAdapter(requireContext())

        binding.listView.layoutManager = object :  LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.listView.adapter =leftAdapter



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}