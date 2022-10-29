package com.example.foodapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Yemekler
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.databinding.CardTasarimBinding
import com.example.foodapp.ui.fragment.AnasayfaFragmentDirections
import com.example.foodapp.ui.fragment.YemekDetayFragment
import com.example.foodapp.ui.fragment.YemekDetayFragmentDirections
import com.example.foodapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetYemeklerAdapter(var mContext: Context, var yemeklerListesi:List<SepetYemekler>)
    :RecyclerView.Adapter<SepetYemeklerAdapter.CardTasarimTutucu>() {


        inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
            var tasarim:CardTasarimBinding
            init {
                this.tasarim = tasarim
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
    val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
    return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
      val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}").into(t.yemekResmi)
        t.yemekAdi.text = "${yemek.yemek_adi}"
        t.yemekFiyati.text = "${yemek.yemek_fiyat} ₺"


    }


    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }













}