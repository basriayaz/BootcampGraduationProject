package com.example.foodapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.Yemek
import com.example.foodapp.databinding.CardTasarimBinding
import com.example.foodapp.databinding.SepetCardTasarimBinding
import com.example.foodapp.ui.fragment.AnasayfaFragmentDirections
import com.example.foodapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetYemeklerAdapter(var mContext: Context, var sepetYemeklerListesi:List<SepetYemekler>)
    :RecyclerView.Adapter<SepetYemeklerAdapter.CardTasarimTutucu>() {


        inner class CardTasarimTutucu(tasarim:SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
            var tasarim:SepetCardTasarimBinding
            init {
                this.tasarim = tasarim
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
    val tasarim = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
    return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
      val yemek = sepetYemeklerListesi.get(position)
        val t = holder.tasarim
        t.sepetYemekAdi.text = "Ayran"
        t.sepetYemekFiyati.text = "3₺"
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}").into(t.sepetYemekResmi)
    }


    override fun getItemCount(): Int {
        return sepetYemeklerListesi.size
    }













}