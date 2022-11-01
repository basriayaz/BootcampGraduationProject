package com.example.foodapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repo.IslemlerRepo
import com.example.foodapp.data.repo.SepetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekDetayViewModel @Inject constructor(var yrepo: IslemlerRepo, var srepo: SepetRepo) :
    ViewModel() {
    var sonuc = MutableLiveData<String>()

    init {
        sonuc = yrepo.RepoSonucGetir()
    }

    fun Arttir(adetSayisi: String) {
        yrepo.arttir(adetSayisi)
    }


    fun Azalt(adetSayisi: String) {
        yrepo.azalt(adetSayisi)
    }

    fun sepeteEkle(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) {
        srepo.sepeteEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }

}