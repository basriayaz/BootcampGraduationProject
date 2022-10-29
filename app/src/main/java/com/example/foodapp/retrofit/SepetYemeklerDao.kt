package com.example.foodapp.retrofit

import com.example.foodapp.data.entity.CRUDCevap
import com.example.foodapp.data.entity.SepetYemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SepetYemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
    //http://kasimadalan.pe.hu/yemekler/resimler/ayran.png



    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun tumSepetiGetir(@Field("kullanici_adi") kullanici_adi : String) : Call<SepetYemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepeteKaydet(@Field("yemek_adi") yemek_adi : String,
                     @Field("yemek_resim_adi") yemek_resim_adi : String,
                     @Field("yemek_fiyat") yemek_fiyat : Int,
                     @Field("yemek_siparis_adet") yemek_siparis_adet : Int,
                     @Field("kullanici_adi") kullanici_adi : String) : Call<CRUDCevap>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettekiYemekSil(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                          @Field("kullanici_adi") kullanici_adi : String) : Call<CRUDCevap>


}