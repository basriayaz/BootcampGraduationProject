package com.example.foodapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.Yemekler
import com.example.foodapp.data.entity.YemeklerCevap
import com.example.foodapp.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslemlerRepo(var ydao :YemeklerDao) {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    var RepoSonuc = MutableLiveData<String>()

    init {
        yemeklerListesi = MutableLiveData()
    }

    init {
        RepoSonuc = MutableLiveData<String>("0")
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun RepoSonucGetir() : MutableLiveData<String>{

        return RepoSonuc
    }

    //İki farklı fonksiyonda sonuc değerini değiştiriyoruz buna side effect deniyor
    fun arttir(adetSayisi:String){
        var adet = adetSayisi.toInt()
        adet += 1
        RepoSonuc.value = adet.toString()
    }

    fun azalt(adetSayisi:String){
        var adet = adetSayisi.toInt()
        adet -= 1
        RepoSonuc.value = adet.toString()

    }

    fun tumYemekleriGetir(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
               val liste = response.body()!!.yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}

            }
        )
    }
    fun yemekAra(aramaKelimesi:String){
        ydao.yemekAra(aramaKelimesi).enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}

        }
        )
    }


}


