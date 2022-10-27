package com.example.foodapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.Yemekler
import com.example.foodapp.data.repo.IslemlerRepo

class AnasayfaViewModel :ViewModel() {
    var yrepo = IslemlerRepo()
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }


    fun yemekleriYukle(){
        yrepo.tumYemekleriGetir()
    }

}