package com.example.foodapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class AViewModel : ViewModel() {
var sonuc = MutableLiveData<String>()

    init {
        sonuc = MutableLiveData<String>("0")
    }
    //İki farklı fonksiyonda sonuc değerini değiştiriyoruz buna side effect deniyor
    fun Arttir(adetSayisi:String){
        var adet = adetSayisi.toInt()
        adet += 1
        sonuc.value = adet.toString()
    }


    fun Azalt(adetSayisi:String){
        var adet = adetSayisi.toInt()
        adet -= 1
        sonuc.value = adet.toString()

    }
}