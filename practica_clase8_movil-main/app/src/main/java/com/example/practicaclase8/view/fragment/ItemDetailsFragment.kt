package com.example.practicaclase8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.practicaclase8.R
import com.example.practicaclase8.databinding.FragmentItemDetailsBinding
import com.example.practicaclase8.model.Inventory
import com.example.practicaclase8.viewmodel.InventoryViewModel


class ItemDetailsFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailsBinding
    private val inventoryViewModel: InventoryViewModel by viewModels()
    private lateinit var receivedInventory: Inventory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        dataInventory()
    }

    private fun controladores() {
        binding.btnDelete.setOnClickListener {
            deleteInventory()
        }

        binding.fbEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("dataInventory", receivedInventory)
            findNavController().navigate(R.id.action_itemDetailsFragment_to_itemEditFragment, bundle)
        }


    }

    private fun deleteInventory() {
        inventoryViewModel.deleteInventory(receivedInventory)
        inventoryViewModel.getListInvetory()
        findNavController().popBackStack()
    }

    private fun dataInventory(){
        val receivedBundle = arguments
        receivedInventory = receivedBundle?.getSerializable("clave") as Inventory
        binding.tvItem.text ="${receivedInventory.name}"
        binding.tvPrice.text = "$ ${receivedInventory.price}"
        binding.tvQuantity.text = "${receivedInventory.quantity}"
    }
}