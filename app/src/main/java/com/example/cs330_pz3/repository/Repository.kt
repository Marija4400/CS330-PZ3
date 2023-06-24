package com.example.cs330_pz3.repository

import com.example.cs330_pz3.common.ApiService
import com.example.cs330_pz3.common.RetrofitHelper
import com.example.cs330_pz3.data.ReceptItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {

    var receptiFlow : Flow<List<ReceptItem>> = flowOf(listOf())

    suspend fun loadRecepti(){
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val result = apiService.getRecepti()
        if(result !=null)
            receptiFlow = flowOf(result)
    }




}