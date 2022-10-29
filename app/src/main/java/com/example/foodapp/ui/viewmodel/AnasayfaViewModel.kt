package com.example.foodapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.Yemekler
import com.example.foodapp.data.repo.IslemlerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor (var yrepo : IslemlerRepo) :ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }


    fun yemekleriYukle(){
        yrepo.tumYemekleriGetir()
    }
    fun ara(aramaKelimesi:String){
        yrepo.yemekAra(aramaKelimesi)
    }

}