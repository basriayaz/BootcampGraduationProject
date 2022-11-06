package com.example.foodapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.data.entity.CRUDCevap
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.data.entity.SepetYemeklerCevap
import com.example.foodapp.retrofit.SepetYemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SepetRepo(var sdao: SepetYemeklerDao) {
    var nick_name:String = "iskocyali"
    var sepetListesi: MutableLiveData<List<SepetYemekler>>

    init {
        sepetListesi = MutableLiveData()
    }

    fun sepetiGetir(): MutableLiveData<List<SepetYemekler>> {
        return sepetListesi
    }


    fun tumSepetGetir(kullanici_adi: String) {
        sdao.tumSepetiGetir(kullanici_adi).enqueue(object : Callback<SepetYemeklerCevap> {
            override fun onResponse(
                call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>
            ) {
                val liste = response.body()!!.sepetYemekler
                val sonliste = ArrayList<SepetYemekler>()


                for (i in 0..liste.size - 1) {
                    val yemek = SepetYemekler(
                        liste[i].sepet_yemek_id,
                        liste[i].yemek_adi,
                        liste[i].yemek_resim_adi,
                        liste[i].yemek_fiyat,
                        liste[i].yemek_siparis_adet,
                        nick_name
                    )
                    if (liste[i].yemek_adi == "var") {
                        continue
                    }
                    if (i != liste.size - 1) { //J nin değeri liste boyunu aşmasın diye eklendi
                        for (j in i + 1..liste.size - 1) {

                            if (yemek.yemek_adi == liste[j].yemek_adi) {
                                liste[j].yemek_adi = "var"
                                liste[i].yemek_siparis_adet += liste[j].yemek_siparis_adet
                            }
                        }
                    }
                }

                for (i in 0..liste.size - 1) {
                    if (liste[i].yemek_adi != "var") {
                        sonliste.add(liste[i])
                    }
                }

                sepetListesi.value = sonliste

            }

            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {
                val emptyList: List<SepetYemekler> = emptyList()
                sepetListesi.value = emptyList
            }
        })
    }


    fun sepetYemekSil(sepet_yemek_id: Int, kullanici_adi: String) {
        sdao.sepettekiYemekSil(sepet_yemek_id, kullanici_adi).enqueue(object : Callback<CRUDCevap> {
                override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                    tumSepetGetir(kullanici_adi)
                }

                override fun onFailure(call: Call<CRUDCevap>, t: Throwable?) {
                }
            })
    }


    fun sepeteEkle(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) {
        sdao.sepeteKaydet(
            yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi
        ).enqueue(object : Callback<CRUDCevap> {
                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                }

                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                }
            })
    }


}