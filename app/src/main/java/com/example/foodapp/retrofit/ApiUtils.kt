package com.example.foodapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDap() : YemeklerDao {
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)

        }
    }
}