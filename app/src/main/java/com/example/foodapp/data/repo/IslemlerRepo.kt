package com.example.foodapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.foodapp.Yemekler
import com.example.foodapp.data.entity.YemeklerCevap
import com.example.foodapp.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslemlerRepo() {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    var RepoSonuc = MutableLiveData<String>()
    init {
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }



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

    fun tumYemekleriGetir(){
        val liste = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"Ayran","ayran",3)
        val y2 = Yemekler(2,"Ayran","ayran",3)
        val y3 = Yemekler(3,"Ayran","ayran",3)
        val y4 = Yemekler(4,"Ayran","ayran",3)
        val y5 = Yemekler(5,"Ayran","ayran",3)
        val y6 = Yemekler(6,"Ayran","ayran",3)
        val y7 = Yemekler(7,"Ayran","ayran",3)
        val y8 = Yemekler(8,"Ayran","ayran",3)

        liste.add(y1)
        liste.add(y2)
        liste.add(y3)
        liste.add(y4)
        liste.add(y5)
        liste.add(y6)
        liste.add(y7)
        liste.add(y8)
        yemeklerListesi.value = liste

    }


}