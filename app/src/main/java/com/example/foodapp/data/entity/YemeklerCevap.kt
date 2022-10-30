package com.example.foodapp.data.entity

import com.google.gson.annotations.SerializedName

data class YemeklerCevap(@SerializedName("yemekler") var yemekler:List<Yemek>,
                         @SerializedName("success") var success:Int) {
}