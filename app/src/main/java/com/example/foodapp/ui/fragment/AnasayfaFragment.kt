package com.example.foodapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodapp.ui.viewmodel.YemekDetayViewModel
import com.example.foodapp.R
import com.example.foodapp.Yemekler
import com.example.foodapp.databinding.FragmentAnasayfaBinding
import com.example.foodapp.ui.adapter.YemeklerAdapter

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private val viewModel: YemekDetayViewModel by viewModels() //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false)

        tasarim.toolbarAnasayfa.title = "Anasayfa"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

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

    override fun onQueryTextSubmit(query: String): Boolean {
    ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
    ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
    Log.e("Yemek Ara",aramaKelimesi)
    }
}