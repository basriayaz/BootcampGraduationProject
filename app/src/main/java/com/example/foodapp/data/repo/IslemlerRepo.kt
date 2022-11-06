package com.example.foodapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.data.entity.*
import com.example.foodapp.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslemlerRepo(var ydao: YemeklerDao) {
    var yemeklerListesi: MutableLiveData<List<Yemek>>
    var filtreliYemekler: MutableLiveData<List<Yemek>>
    var RepoSonuc = MutableLiveData<String>()


    init {
        yemeklerListesi = MutableLiveData()
        filtreliYemekler = MutableLiveData()
        RepoSonuc = MutableLiveData<String>("0")
    }


    fun yemekleriGetir(): MutableLiveData<List<Yemek>> {
        return filtreliYemekler

    }

    fun RepoSonucGetir(): MutableLiveData<String> {
        return RepoSonuc
    }

    fun arttir(adetSayisi: String) {
        var adet = adetSayisi.toInt()
        adet += 1
        RepoSonuc.value = adet.toString()
    }

    fun azalt(adetSayisi: String) {
        var adet = adetSayisi.toInt()
        if(adet>0) {
            adet -= 1
        }
        RepoSonuc.value = adet.toString()

    }


    fun tumYemekleriGetir() {
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                yemeklerListesi.value = liste
                filtreliYemekler.value = liste

            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}

        }
        )
    }

    fun yemekAra(aramaKelimesi: String) {
        filtreliYemekler.value = yemeklerListesi.value?.filter {
            it.yemek_adi.lowercase().contains(aramaKelimesi)
        }
    }


}


