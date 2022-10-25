package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodapp.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private val viewModel: AViewModel by viewModels() //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false)



        //Buraya Yemek Listesi tanımlayacağız sonradan bu listeyi Retrofit ile alacağız
        val yemeklerListesi = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"Ayran","ayran",3)
        val y2 = Yemekler(2,"Ayran","ayran",3)
        val y3 = Yemekler(3,"Ayran","ayran",3)
        val y4 = Yemekler(4,"Ayran","ayran",3)
        val y5 = Yemekler(5,"Ayran","ayran",3)
        val y6 = Yemekler(6,"Ayran","ayran",3)
        val y7 = Yemekler(7,"Ayran","ayran",3)
        val y8 = Yemekler(8,"Ayran","ayran",3)

        yemeklerListesi.add(y1)
        yemeklerListesi.add(y2)
        yemeklerListesi.add(y3)
        yemeklerListesi.add(y4)
        yemeklerListesi.add(y5)
        yemeklerListesi.add(y6)
        yemeklerListesi.add(y7)
        yemeklerListesi.add(y8)


        tasarim.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        val adapter = YemeklerAdapter(requireContext(),yemeklerListesi)
        tasarim.rv.adapter = adapter
        return tasarim.root
    }
}