package com.example.foodapp.ui.viewmodel





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.Yemekler
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.repo.IslemlerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor (var yrepo : IslemlerRepo) : ViewModel() {
    var sepetYemeklerListesi = MutableLiveData<List<SepetYemekler>>()

    init {
        sepetYemekleriYukle()
        //sepetYemeklerListesi = yrepo.yemekleriGetir()
    }


    fun sepetYemekleriYukle(){
        yrepo.tumYemekleriGetir()
    }


}