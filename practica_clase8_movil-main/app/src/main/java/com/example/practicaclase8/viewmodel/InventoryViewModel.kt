package com.example.practicaclase8.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.practicaclase8.model.Inventory
import com.example.practicaclase8.model.Product
import com.example.practicaclase8.repository.InventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InventoryViewModel(application: Application): AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val inventoryRepository = InventoryRepository(context)

    private val _listInventory = MutableLiveData<MutableList<Inventory>>()
    val listInventory: LiveData<MutableList<Inventory>> get() = _listInventory

    private val _listProducts = MutableLiveData<MutableList<Product>>()
    val listProducts: LiveData<MutableList<Product>> = _listProducts

    fun saveInventory(inventory: Inventory){
        viewModelScope.launch {
            inventoryRepository.saveInventory(inventory)
        }
    }

    fun getListInvetory(){
        viewModelScope.launch {
            _listInventory.value = inventoryRepository.getListInventory()

        }
    }

    fun deleteInventory(inventory: Inventory){
        viewModelScope.launch {
            inventoryRepository.deleteInventory(inventory)
        }
    }

    fun updateInventory(inventory: Inventory){
        viewModelScope.launch {
            inventoryRepository.updateRepositoy(inventory)
        }
    }

    fun getProducts() {
        viewModelScope.launch {
            _listProducts.value = inventoryRepository.getProducts()
        }
    }
}