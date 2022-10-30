package com.example.foodapp.ui.viewmodel





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.data.repo.IslemlerRepo
import com.example.foodapp.data.repo.SepetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor (var yrepo : SepetRepo) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<SepetYemekler>>()


    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.sepetiGetir()
    }
    fun yemekleriYukle(){
        yrepo.tumSepetGetir("iskocyali")
    }
}