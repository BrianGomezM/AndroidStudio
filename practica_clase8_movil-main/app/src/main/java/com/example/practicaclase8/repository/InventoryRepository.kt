package com.example.practicaclase8.repository

import android.content.Context
import com.example.practicaclase8.data.InventoryDB
import com.example.practicaclase8.data.InventoryDao
import com.example.practicaclase8.model.Inventory
import com.example.practicaclase8.model.Product
import com.example.practicaclase8.webservice.ApiService
import com.example.practicaclase8.webservice.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InventoryRepository (val context: Context){
    private var inventoryDao: InventoryDao = InventoryDB.getDatabase(context).inventoryDao()
    private var apiService: ApiService = ApiUtils.getApiService()

     suspend fun saveInventory(inventory: Inventory){
        withContext(Dispatchers.IO){
            inventoryDao.saveInventory(inventory)
        }
    }
    suspend fun getListInventory():MutableList<Inventory>{
        return withContext(Dispatchers.IO){
            inventoryDao.getListInventory()
        }
    }

    suspend fun deleteInventory(inventory: Inventory){
        withContext(Dispatchers.IO){
            inventoryDao.deleteInventory(inventory)
        }
    }

    suspend fun updateRepositoy(inventory: Inventory){
        withContext(Dispatchers.IO){
            inventoryDao.updateInventory(inventory)
        }
    }

    suspend fun getProducts(): MutableList<Product> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getProducts()
                response
            } catch (e: Exception) {
                // Manejar el error
                e.printStackTrace()
                mutableListOf()
            }
        }
    }



}