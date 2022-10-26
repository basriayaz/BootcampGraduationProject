package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.foodapp.ui.viewmodel.YemekDetayViewModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentYemekDetayBinding
import com.google.android.material.snackbar.Snackbar


class YemekDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekDetayBinding
    private val viewModel: YemekDetayViewModel by viewModels() //View Modeli Fragmenta bağladık
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayNesnesi = this
        tasarim.hesaplamaSonucu = "0"
        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        tasarim.toolbarDetay.title = gelenYemek.yemek_adi
        tasarim.ivYemek.setImageResource(resources.getIdentifier(gelenYemek.yemek_resim_adi,"drawable",requireContext().packageName))
        tasarim.tvYemekAdi.text = gelenYemek.yemek_adi
        tasarim.tvYemekFiyat.text = gelenYemek.yemek_fiyat.toString()

        tasarim.ivSepeteGit.setOnClickListener{
            Snackbar.make(it,"Ürün Sepete Eklendi",Snackbar.LENGTH_SHORT).show()
        }
        return tasarim.root
    }

    fun adetArttir(adetSayisi:String){
            viewModel.Arttir(adetSayisi)
        viewModel.sonuc.observe(this,{tasarim.hesaplamaSonucu = it})
    }


    fun adetAzalt(adetSayisi:String){
        viewModel.Azalt(adetSayisi)
        viewModel.sonuc.observe(this,{tasarim.hesaplamaSonucu = it})
    }
    fun sepeteGit(){
        Snackbar.make(tasarim.ivEkle,"Ürün Sepetten Çıkarıldı",Snackbar.LENGTH_SHORT).show()
    }

}