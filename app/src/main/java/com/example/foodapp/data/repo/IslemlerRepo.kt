package com.example.foodapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.foodapp.data.entity.YemeklerCevap
import com.example.foodapp.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslemlerRepo() {

    var RepoSonuc = MutableLiveData<String>()

    init {
        RepoSonuc = MutableLiveData<String>("0")
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


}