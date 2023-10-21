package com.example.practicaclase8.view.viewholder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaclase8.R
import com.example.practicaclase8.databinding.ItemInventoryBinding
import com.example.practicaclase8.model.Inventory

class InventoryViewHolder (binding: ItemInventoryBinding,navController: NavController):RecyclerView.ViewHolder(binding.root){
    val bindingItem = binding
    val navController = navController

    fun setItemInventory(inventory: Inventory){
        bindingItem.tvName.text = inventory.name
        bindingItem.tvPrice.text = "$ ${inventory.price}"
        bindingItem.tvQuantity.text = "${inventory.quantity}"
        bindingItem.cvInventory.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clave",inventory)
            navController.navigate(R.id.action_homeInvetoryFragment_to_itemDetailsFragment,bundle)
        }
    }

}