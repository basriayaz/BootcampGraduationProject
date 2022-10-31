package com.example.foodapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.data.repo.IslemlerRepo
import com.example.foodapp.data.repo.SepetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor (var yrepo : IslemlerRepo,var srepo : SepetRepo) :ViewModel() {
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

    fun sepeteEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        srepo.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }


}