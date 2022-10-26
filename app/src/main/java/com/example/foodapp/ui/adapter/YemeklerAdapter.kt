package com.example.foodapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.data.entity.Yemekler
import com.example.foodapp.databinding.CardTasarimBinding
import com.example.foodapp.ui.fragment.AnasayfaFragmentDirections
import com.example.foodapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class YemeklerAdapter(var mContext: Context, var yemeklerListesi:List<Yemekler>)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {


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
        t.yemekResmi.setImageResource(
            mContext.resources.getIdentifier(yemek.yemek_resim_adi,"drawable",mContext.packageName))
        t.yemekAdi.text = "${yemek.yemek_adi}"
        t.yemekFiyati.text = "${yemek.yemek_fiyat} ₺"

        t.imageView2.setOnClickListener{
            Snackbar.make(it,"Yemek Sepete eklendi",Snackbar.LENGTH_SHORT).show()

        }

        t.cvYemek.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemek = yemek)
            Navigation.gecisYap(it,gecis)
        }
    }


    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }













}