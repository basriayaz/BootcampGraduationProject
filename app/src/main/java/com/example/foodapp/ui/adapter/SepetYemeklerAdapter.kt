package com.example.foodapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.databinding.CardTasarimBinding
import com.example.foodapp.databinding.SepetCardTasarimBinding
import com.example.foodapp.ui.fragment.AnasayfaFragmentDirections
import com.example.foodapp.ui.viewmodel.SepetViewModel
import com.example.foodapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetYemeklerAdapter(
    var mContext: Context,
    var viewModel: SepetViewModel,
    var sepetYemeklerListesi: List<SepetYemekler>
) : RecyclerView.Adapter<SepetYemeklerAdapter.SepetCardTasarimTutucu>() {


    inner class SepetCardTasarimTutucu(tasarim: SepetCardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: SepetCardTasarimBinding

        init {
            this.tasarim = tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val tasarim = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val yemek = sepetYemeklerListesi.get(position)
        val t = holder.tasarim
        t.sepetYemekAdi.text = yemek.yemek_adi
        t.sepetYemekFiyati.text =
            "${(yemek.yemek_siparis_adet * yemek.yemek_fiyat).toString()},00 TL"
        t.sepetUrunAdedi.text = yemek.yemek_siparis_adet.toString()
        t.ivSilYemek.setOnClickListener {
            viewModel.yemekSil(yemek.sepet_yemek_id)
        }
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
            .into(t.sepetYemekResmi)
    }


    override fun getItemCount(): Int {
        return sepetYemeklerListesi.size
    }



}