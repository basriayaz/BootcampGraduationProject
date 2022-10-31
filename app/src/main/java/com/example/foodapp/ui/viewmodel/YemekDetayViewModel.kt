package com.example.foodapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repo.IslemlerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekDetayViewModel @Inject constructor (var yrepo : IslemlerRepo) : ViewModel() {
var sonuc = MutableLiveData<String>()
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