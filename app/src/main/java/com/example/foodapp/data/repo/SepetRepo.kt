package com.example.foodapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.data.entity.CRUDCevap
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.SepetYemeklerCevap
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.retrofit.SepetYemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SepetRepo(var sdao:SepetYemeklerDao) {
    var sepetListesi : MutableLiveData<List<SepetYemekler>>

    init {
        sepetListesi = MutableLiveData()
    }
    fun sepetiGetir() : MutableLiveData<List<SepetYemekler>>{
        return  sepetListesi
    }

    fun tumSepetGetir(kullanici_adi:String){
        sdao.tumSepetiGetir(kullanici_adi).enqueue(object: Callback<SepetYemeklerCevap> {
            override fun onResponse(call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>) {
                val liste = response.body()!!.sepetYemekler
                sepetListesi.value = liste

            }
            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {
                val emptyList:List<SepetYemekler> = emptyList()
                sepetListesi.value = emptyList
            }
        })
    }

    fun sepetYemekSil(sepet_yemek_id:Int,kullanici_adi: String){
        sdao.sepettekiYemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                tumSepetGetir(kullanici_adi)
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }
    fun sepeteEkle(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
        sdao.sepeteKaydet(yemek_adi,yemek_resim_adi,yemek_fiyat, yemek_siparis_adet, kullanici_adi)
            .enqueue(object:Callback<CRUDCevap>{
                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                }
                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
            })
    }
}