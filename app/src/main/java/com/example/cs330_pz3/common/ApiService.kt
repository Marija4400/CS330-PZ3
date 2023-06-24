package com.example.cs330_pz3.common

import com.example.cs330_pz3.data.ReceptItem
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.RECEPT_URL)
    suspend fun getRecepti(): List<ReceptItem>

}