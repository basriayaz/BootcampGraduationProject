package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.data.entity.SepetYemekler
import com.example.foodapp.databinding.FragmentSepetBinding
import com.example.foodapp.ui.adapter.SepetYemeklerAdapter
import com.example.foodapp.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var tasarim: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentSepetBinding.inflate(inflater, container, false)

        tasarim.toolbarSepet.title = "Sepet Sayfası"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarSepet)


        viewModel.yemeklerListesi.observe(viewLifecycleOwner) {
            tasarim.rv2.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            val adapter = SepetYemeklerAdapter(requireContext(), viewModel, it)
            tasarim.rv2.adapter = adapter
            tasarim.totalUcret.text = "Toplam Tutar : ${totalFiyat(it).toString()} TL"
        }
        tasarim.siparisVer.setOnClickListener {
            if(tasarim.totalUcret.text!="Toplam Tutar : 0 TL"){
            Navigation.findNavController(it).navigate(R.id.siparisTamamlandiGecis)
            Snackbar.make(it,"Siparişiniz yola çıktı, yaklaşık 30 dakika içerisinde size ulaşacak", Snackbar.LENGTH_SHORT)
                .show()
        }else{
                Snackbar.make(it,"Sepetiniz Boş, Lütfen bir ürün ekleyerek tekrar deneyin", Snackbar.LENGTH_SHORT)
                    .show()
        }

        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun totalFiyat(it:List<SepetYemekler>) : Int{
        var toplamTutar = 0
        for(i in 0..it.size-1){
            toplamTutar = (it[i].yemek_fiyat*it[i].yemek_siparis_adet)+toplamTutar
        }

        return toplamTutar
    }
}