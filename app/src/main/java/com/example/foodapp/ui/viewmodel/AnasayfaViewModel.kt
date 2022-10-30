package com.example.foodapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.data.repo.IslemlerRepo
import com.example.foodapp.data.repo.SepetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor (var yrepo : IslemlerRepo) :ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemek>>()


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