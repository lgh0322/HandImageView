package com.viatom.blood.ui.history

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.viatom.blood.MainApplication
import com.viatom.blood.ui.history.detail.LPM311HistoryDetailActivity
import com.viatom.blood.databinding.Lpm311FragmentHistoryBinding
import com.viatom.blood.room.LPM311AppDatabase
import com.viatom.blood.ui.history.adapter.LPM311HistoryAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LPM311HistoryFragment : Fragment() {

    private var _binding: Lpm311FragmentHistoryBinding? = null


    private val binding get() = _binding!!
    var currentIndex = 0
    lateinit var navController: NavController
    private lateinit var leftAdapter: LPM311HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val LPM311HistoryViewModel =
            ViewModelProvider(this).get(LPM311HistoryViewModel::class.java)

        _binding = Lpm311FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        leftAdapter=LPM311HistoryAdapter(requireContext())



        binding.leftView.layoutManager = object :  LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.leftView.adapter =leftAdapter
        leftAdapter.click=object:LPM311HistoryAdapter.Click{
            override fun clickItem(position: Int) {
                startActivity(Intent(requireActivity(), LPM311HistoryDetailActivity::class.java))
            }

        }

        MainApplication.dataScope.launch {
            val a=LPM311AppDatabase.lpmDb.lpmDao().getAllR()
            Log.e("faa",a.size.toString())
            withContext(Dispatchers.Main){
                leftAdapter.addAll(a)
            }

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}