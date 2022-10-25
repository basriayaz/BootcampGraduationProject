package com.example.foodapp

import java.io.Serializable

data class Yemekler(var yemek_id:Int,
                    val yemek_adi:String,
                    var yemek_resim_adi:String,
                    var yemek_fiyat:Int): Serializable {
}