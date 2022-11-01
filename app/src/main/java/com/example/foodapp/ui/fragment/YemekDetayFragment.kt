package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.foodapp.ui.viewmodel.YemekDetayViewModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentYemekDetayBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekDetayBinding
    private lateinit var viewModel: YemekDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayNesnesi = this
        tasarim.hesaplamaSonucu = "0"
        
        val bundle: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        tasarim.toolbarDetay.title = gelenYemek.yemek_adi.toString()
            tasarim.toolbarDetay.title = gelenYemek.yemek_adi
        Picasso.get()
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}")
            .into(tasarim.ivYemek)
        tasarim.tvYemekAdi.text = gelenYemek.yemek_adi
        tasarim.tvYemekFiyat.text = "${gelenYemek.yemek_fiyat.toString()} ₺"
        tasarim.ivSepeteGit.setOnClickListener {

            for(i in 1..tasarim.tvYemekAdet.text.toString().toInt()) {
                viewModel.sepeteEkle(
                    gelenYemek.yemek_adi,
                    gelenYemek.yemek_resim_adi,
                    gelenYemek.yemek_fiyat,
                    1,
                    "iskocyali"
                )
            }
            Thread.sleep(300)
            Navigation.findNavController(it).navigate(R.id.detayGecis2)

        }

        return tasarim.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YemekDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    //------------------------------------------------------------------------------------------------------------------------------->>
    fun adetArttir(adetSayisi: String) {
        viewModel.Arttir(adetSayisi)
        viewModel.sonuc.observe(this, { tasarim.hesaplamaSonucu = it })
    }

    fun adetAzalt(adetSayisi: String) {
        viewModel.Azalt(adetSayisi)
        viewModel.sonuc.observe(this, { tasarim.hesaplamaSonucu = it })
    }


}