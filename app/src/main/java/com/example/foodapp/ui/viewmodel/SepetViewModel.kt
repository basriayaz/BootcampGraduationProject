package com.example.foodapp.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.repo.SepetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var srepo: SepetRepo) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<SepetYemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = srepo.sepetiGetir()
    }

    fun yemekleriYukle() {
        srepo.tumSepetGetir("iskocyali")
    }

    fun yemekSil(yemek_id: Int) {
        srepo.sepetYemekSil(yemek_id, "iskocyali")
        yemekleriYukle()
    }

    fun tumYemekSil(yemek_id: Int){
        srepo.sepetYemekSil(yemek_id,"iskocyali")
    }


}