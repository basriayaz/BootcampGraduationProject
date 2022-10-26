package com.example.foodapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repo.IslemlerRepo

class YemekDetayViewModel : ViewModel() {
var sonuc = MutableLiveData<String>()
var yrepo = IslemlerRepo()
    init {
        sonuc = yrepo.RepoSonucGetir()
    }
    //İki farklı fonksiyonda sonuc değerini değiştiriyoruz buna side effect deniyor

    fun Arttir(adetSayisi:String){
        yrepo.arttir(adetSayisi)
    }


    fun Azalt(adetSayisi:String){
        yrepo.azalt(adetSayisi)
    }
}