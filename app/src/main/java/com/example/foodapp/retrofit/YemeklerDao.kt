package com.example.foodapp.retrofit

import com.example.foodapp.data.entity.CRUDCevap
import com.example.foodapp.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler(): Call<YemeklerCevap>
}