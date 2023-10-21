package com.example.practicaclase8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaclase8.R
import com.example.practicaclase8.databinding.FragmentHomeInvetoryBinding
import com.example.practicaclase8.model.Inventory
import com.example.practicaclase8.view.adapter.InventoryAdapter
import com.example.practicaclase8.viewmodel.InventoryViewModel

class HomeInventoryFragment : Fragment() {
    private lateinit var binding: FragmentHomeInvetoryBinding
    private val inventoryViewModel: InventoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeInvetoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observerViewModel()
    }

    private fun observerViewModel() {
       observerListInventory()
    }

    private fun observerListInventory() {
        inventoryViewModel.getListInvetory()
        inventoryViewModel.listInventory.observe(viewLifecycleOwner){ listaInventory->
            val recycler = binding.recyclerview
            val layoutManager = LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = InventoryAdapter(listaInventory, findNavController())
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }

    private fun controladores() {
        binding.fbagregar.setOnClickListener {
            findNavController().navigate(R.id.action_homeInvetoryFragment_to_addItemFragment)
        }
    }

    fun recycler(){


//        val recycler = binding.recyclerview
//        recycler.layoutManager = LinearLayoutManager(context)
//        val adapter = InventoryAdapter(listInventory)
//        recycler.adapter =adapter
//        adapter.notifyDataSetChanged()


    }
}